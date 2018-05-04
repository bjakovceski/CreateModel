package entityTypes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class FindEntityTypes {
//    private static List<String> fileNames = new LinkedList<>();
//    private static List<String> instanceTypeFileNames = new LinkedList<>();
//
//    private static void listFilesForNifLinksFolder(final File folder, String type) {
//        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
//            if (fileEntry.isDirectory()) {
//                listFilesForNifLinksFolder(fileEntry, type);
//            } else {
//                if(type == "links") {
//                    fileNames.add(fileEntry.getAbsolutePath());
//                } else {
//                    instanceTypeFileNames.add(fileEntry.getAbsolutePath());
//                }
//            }
//        }
//    }

    private static List<String> stopWords = new ArrayList<String>();

    static {
        try {
            stopWords = Files.readAllLines(Paths.get("C:\\Users\\Jakovcheski\\Desktop\\THESIS\\stopwords.list"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> readFromNifLinks(String link, List<String> fileLinksName, List<String> instanceTypeFileNames) throws IOException {
//        //links
//        final File folder = new File("C:\\Users\\Jakovcheski\\Desktop\\DataTree");
//        listFilesForNifLinksFolder(folder, "links");
//        //instance types
//
//        final File instanceTypesFolder = new File("C:\\Users\\Jakovcheski\\Desktop\\InstanceTypes");
//        listFilesForNifLinksFolder(instanceTypesFolder, "instances");

        Map<String, String> types = new LinkedHashMap<>();
        boolean foundLinkFile = false;
        System.err.println("Link " + link);
        String[] parsedLink = link.split("resource/");
        String firstTwoCharactersFromNameLink = parsedLink[1].substring(0, 2).toLowerCase();
        String file = "";

        if (firstTwoCharactersFromNameLink.startsWith("\'")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\'\\apostrophe.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("-")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\-\\hyphen.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("!")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\!\\exclamation.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("$")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\$\\dolar.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("0")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\0\\zero.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("1")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\1\\one.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("2")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\2\\two.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("3")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\3\\three.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("4")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\4\\four.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("5")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\5\\five.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("6")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\6\\six.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("7")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\7\\seven.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("8")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\8\\eight.ttl";
        } else if (firstTwoCharactersFromNameLink.startsWith("9")) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTreeSpecialCharacters\\9\\nine.ttl";
        } else {
            for (String fileName : fileLinksName) {
                String[] parsedFilePath = fileName.split("\\\\");
                if (parsedFilePath[parsedFilePath.length - 1].substring(0, 2).equals(firstTwoCharactersFromNameLink)) {
                    foundLinkFile = true;
                    file = fileName;
                }
            }
        }
        if (!foundLinkFile) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\DataTree\\other\\other.ttl";
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lineLinks = line.split(">\\s+");
                String[] parsedLinks = lineLinks[0].split("\\?dbpv");

                if (parsedLinks[0].equals(link)) {
                    if (lineLinks[1].contains("#taIdentRef")) {
                        String nextLine = br.readLine();
                        String[] nextLineLinks = nextLine.split(">\\s+");
                        String type = readInstanceTypes(lineLinks[2].substring(1, lineLinks[2].length()), instanceTypeFileNames);
                        if (!type.equals("OTHER")) {
                            types.put(nextLineLinks[2].substring(1, nextLineLinks[2].length() - 3), type); //key: entity, value: type
                        }
                    }
                }

            }
        }
        return types;
    }

    private static String readInstanceTypes(String linkFromNifLinks, List<String> instanceTypeFileNames) throws IOException {
        String file = "";
        boolean foundFile = false;
        String[] parsedLink = linkFromNifLinks.split("resource/");
        if (parsedLink.length == 1) {
            return "OTHER";
        }
        for (String filePath : instanceTypeFileNames) {
            String[] parsedFilePath = filePath.split("InstanceTypes\\\\");
            if (parsedFilePath[1].charAt(0) == parsedLink[1].toLowerCase().charAt(0)) { //error here java.lang.ArrayIndexOutOfBoundsException: 1
                file = filePath;
                foundFile = true;
                break;
            }
        }
        if (!foundFile) {
            file = "C:\\Users\\Jakovcheski\\Desktop\\InstanceTypes\\other.ttl";
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] linkType = line.split(">\\s+<");

                if (linkType[0].substring(1).equals(linkFromNifLinks)) {
                    linkType[2] = linkType[2].substring(0, (linkType[2].length() - 3));
                    String[] type = linkType[2].split("ontology/");
                    return type[1];
                }
            }
            return "OTHER";
        }
    }

    public static void divideTextToWordAtLineWithType(BufferedWriter bw, String text, Map<String, String> entityType,
                                                      BufferedWriter bwGrained) throws IOException {
        Long startTime = System.nanoTime();
        String[] words = text.substring(1, text.length() - 3).split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");
        System.err.println("text " + text);
        System.err.println("\nmap " + entityType);
        if (entityType == null || entityType.isEmpty()) {
            for (String word : words) {
                bw.write(word + "\t" + "O\n");
                bwGrained.write(word + "\t" + "O\n");
            }
            bw.flush();
            bwGrained.flush();
            return;
        }
        Map<String, String> splittedKeyMap = new HashMap<>();
        entityType.forEach((s, v) -> {
            String[] keyWords = s.split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");//split keys from map to one word
            for (String key : keyWords) {
                for (String stopWord : stopWords) {
                    if (!key.equals(stopWord))
                        splittedKeyMap.put(key, v);
                }
            }
        });
        System.err.println("splitted key map " + splittedKeyMap);
        try {
            for (int i = 0; i < words.length; i++) {
                String value = splittedKeyMap.get(words[i]);
                boolean notAStopWord = true;
                for (String stopWord : stopWords) {
                    if (words[i].equals(stopWord)) {
                        notAStopWord = false;
                    }
                }
                if (value != null && !Pattern.matches("\\p{Punct}", words[i]) && notAStopWord) {
                    String keys = (String) getKeyFromValue(entityType, value, words[i]);
                    String[] key = new String[0];
                    if (keys != null) {
                        System.err.println("Word: " + words[i] + " -> Key: " + keys + " -> value: " + value);
                        key = keys.split("\\s");
                    }
                    String keyWords;
                    if (key.length == 1) {
                        bw.write(words[i] + "\t" + value + "\n");
                        bwGrained.write(words[i] + "\t" + value + "\n");
                        splittedKeyMap.remove(words[i]);
                    } else if (key.length > 1) {
                        System.err.println("key lenght " + key.length);
                        StringBuilder keyWordsBuilder = new StringBuilder();
                        for (int j = 0; j < key.length; j++) {
                            if (i <= words.length) {
                                System.err.println("next words: " + words[i]);
                                keyWordsBuilder.append(words[i]).append(" ");
                                i++;
                            }
                        }
                        keyWords = keyWordsBuilder.toString();
                        String newValue = "";
                        String[] formattedString = formatKeyString(keyWords, entityType);
                        if(formattedString[1].equals("1")) {
                            do {
                                StringBuilder additionalWords = new StringBuilder();
                                if (key.length > formattedString[0].split("\\s").length) {
                                    System.err.println("Keys are not same!!!");
                                    int punch = key.length - formattedString[0].split("\\s").length;
                                    System.err.println("Missing words ->  " + punch);
                                    for (int p = 0; p < punch; p++) {
                                        System.err.println("additional words -> " + words[i]);
                                        if(Pattern.matches("\\p{Punct}", words[i])) {
                                            additionalWords.append(words[i]).append(" ").append(words[i+1]).append(" ");
                                            i = i + 2;
                                        }else {
                                            additionalWords.append(words[i]).append(" ");
                                            i++;
                                        }
                                    }
                                    keyWords = keyWords + " " + additionalWords;
                                    formattedString = formatKeyString(keyWords, entityType);
                                    if(formattedString[1].equals("1")){
                                        newValue = entityType.get(formattedString[0]);
                                    } else{
                                        newValue = formattedString[0];
                                        break;
                                    }
                                }
                            } while (key.length > formattedString[0].split("\\s").length);
                        }else{
                            newValue = formattedString[0];
                        }

                        System.err.println("NEW CONCATED WORD2 -> " + formattedString[0]);
                        System.err.println("new value: " + newValue);
                        if (newValue != null && !newValue.equals("")) {
                            for (String keyWord : keyWords.split("\\s")) {
                                bw.write(keyWord + "\t" + newValue + "\n");
                                bwGrained.write(keyWord + "\t" + newValue + "\n");
//                                splittedKeyMap.remove(keyWord);
                            }
                        } else {
                            for (String keyWord : keyWords.split("\\s")) {
                                bw.write(keyWord + "\t" + "O\n");
                                bwGrained.write(keyWord + "\t" + "O\n");
                            }
                        }
                        i--;
                    }
                } else {
                    bw.write(words[i] + "\t" + "O\n");
                    bwGrained.write(words[i] + "\t" + "O\n");
                }
            }
            System.err.println("map after delete " + splittedKeyMap + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bw.flush();
            bwGrained.flush();
            System.err.println("Total time in divideTextToWordAtLineWithType ->  " + (System.nanoTime() - startTime));
        }
    }

    private static Object getKeyFromValue(Map hm, Object value, String word) {
        for (Object o : hm.keySet()) {
            if (o.toString().contains(word)) {
                if (hm.get(o).equals(value)) {
                    return o;
                }
            }
        }
        return null;
    }

    private static String[] formatKeyString(String keyWords, Map<String, String> entityType) {
        keyWords = keyWords.substring(0, keyWords.length() - 1);
        System.err.println("concated words: " + keyWords);
        String newValue = entityType.get(keyWords);
        Boolean isValue = true;
        if (keyWords.endsWith(".") || keyWords.endsWith(",")) {
            newValue = entityType.get(keyWords.substring(0, keyWords.length() - 2));
        } else if (keyWords.contains(".") || keyWords.contains("'") || keyWords.contains(",") || keyWords.contains("\\")
                || keyWords.contains("-") || keyWords.contains("-")) {
            isValue = false;
            System.err.println("!!!!!!!!!!!!!!!CONTAINS PUNCT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            keyWords = keyWords.replaceAll(" \\. ", ". ");
            keyWords = keyWords.replaceAll(" '", "'");
            keyWords = keyWords.replaceAll(" -", "-");
            keyWords = keyWords.replaceAll(" - ", "-");
            keyWords = keyWords.replaceAll(" , ", ",    ");
            keyWords = keyWords.replaceAll(" {2}", " ");
            keyWords = keyWords.replaceAll(" \\.", ".");
            System.err.println("!!!!NEW CONCATED WORD " + keyWords);
        }
        if (isValue) {
            System.err.println("!!!!!new value -> " + newValue);
            return new String[]{newValue, "0"};
        } else {
            System.err.println("!!!!keyWords -> " + keyWords);
            return new String[]{keyWords, "1"};
        }
    }
}

