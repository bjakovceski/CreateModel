package entityTypes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class FindEntityTypes {
    private static List<String> stopWords = new ArrayList<String>();

    static {
        try {
            stopWords = Files.readAllLines(Paths.get("C:\\Users\\Jakovcheski\\Desktop\\THESIS\\stopwords.list"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> readFromNifLinks(String link, List<String> fileLinksName, List<String> instanceTypeFileNames) throws IOException {
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
            if (parsedFilePath[1].charAt(0) == parsedLink[1].toLowerCase().charAt(0)) {
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
        String[] words = new String[0];
        try {
            words = text.substring(1, text.length() - 3).split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");
        } catch (RuntimeException re) {
            re.printStackTrace();
        }

        try {
            if (entityType == null || entityType.isEmpty()) {
                System.err.println("3");
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
            for (int i = 0; i < words.length; i++) {
//                System.err.println("1");
                String value = splittedKeyMap.get(words[i]);
                boolean notAStopWord = true;
                for (String stopWord : stopWords) {
                    if (words[i].equals(stopWord)) {
                        notAStopWord = false;
                    }
                }
                if (value != null && !Pattern.matches("\\p{Punct}", words[i]) && notAStopWord) {
//                    System.err.println("2");
                    String keys = (String) getKeyFromValue(entityType, value, words[i]);
                    String[] key = new String[0];
                    if (keys != null) {
                        key = keys.split("\\s");
                    }
                    String keyWords;
//                    System.err.println("3");
                    if (key.length == 1) {
//                        System.err.println("4");
                        bw.write(words[i] + "\t" + value + "\n");
                        bwGrained.write(words[i] + "\t" + value + "\n");
                        splittedKeyMap.remove(words[i]);
//                        System.err.println("4.1");
                    } else if (key.length > 1) {
//                        System.err.println("5");
                        StringBuilder keyWordsBuilder = new StringBuilder();
                        for (int j = 0; j < key.length; j++) {
                            if (i < words.length) {
                                keyWordsBuilder.append(words[i]).append(" ");
                                i++;
                            }
                        }
//                        System.err.println("6");
                        keyWords = keyWordsBuilder.toString();
                        String newValue = "";
                        String[] formattedString = formatKeyString(keyWords, entityType);
                        if (formattedString[1].equals("1")) {
//                            System.err.println("7");
                            do {
//                                System.err.println("8");
                                StringBuilder additionalWords = new StringBuilder();
                                if (key.length > formattedString[0].split("\\s").length) {
//                                    System.err.println("9");
                                    int punch = key.length - formattedString[0].split("\\s").length;
                                    for (int p = 0; p < punch; p++) {
                                        if (i < words.length) {
                                            if (((i + 1) < words.length) && Pattern.matches("\\p{Punct}", words[i])) {
                                                additionalWords.append(words[i]).append(" ").append(words[i + 1]).append(" ");
                                                i = i + 2;
                                            } else {
                                                additionalWords.append(words[i]).append(" ");
                                                i++;
                                            }
                                        }
                                    }
//                                    System.err.println("10");
                                    keyWords = keyWords + " " + additionalWords;
                                    formattedString = formatKeyString(keyWords, entityType);
                                    if (formattedString[1].equals("1")) {

                                        keyWords = formattedString[0];
                                        if (keyWords.endsWith(" ") || keyWords.endsWith("\\s")) {
                                            keyWords = keyWords.substring(0, keyWords.length() - 1);
                                        }
                                        newValue = entityType.get(keyWords);
                                    } else {
                                        newValue = formattedString[0];
                                        break;
                                    }
                                }
//                                System.err.println("11");
                            } while (key.length > formattedString[0].split("\\s").length);
//                            System.err.println("12");
                        } else {
                            newValue = formattedString[0];
//                            System.err.println("13");
                        }
                        if (newValue != null && !newValue.equals("")) {
//                            System.err.println("14");
                            for (String keyWord : keyWords.split("\\s")) {
                                bw.write(keyWord + "\t" + newValue + "\n");
                                bwGrained.write(keyWord + "\t" + newValue + "\n");
//                                splittedKeyMap.remove(keyWord);
                            }
                            entityType.remove(keyWords);
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

        String newValue = entityType.get(keyWords);
        Boolean isValue = true;
        if (keyWords.endsWith(".") || keyWords.endsWith(",")) {
            newValue = entityType.get(keyWords.substring(0, keyWords.length() - 2));
        } else if (keyWords.contains(".") || keyWords.contains("'") || keyWords.contains(",") || keyWords.contains("\\")
                || keyWords.contains("-") || keyWords.contains("-")) {
            isValue = false;

            keyWords = keyWords.replaceAll(" \\. ", ". ");
            keyWords = keyWords.replaceAll(" '", "'");
            keyWords = keyWords.replaceAll(" -", "-");
            keyWords = keyWords.replaceAll(" - ", "-");
            keyWords = keyWords.replaceAll(" , ", ",    ");
            keyWords = keyWords.replaceAll(" {2}", " ");
            keyWords = keyWords.replaceAll(" \\.", ".");
        }
        if (isValue) {
            return new String[]{newValue, "0"};
        } else {
            return new String[]{keyWords, "1"};
        }
    }
}

