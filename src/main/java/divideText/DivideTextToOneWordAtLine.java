package divideText;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DivideTextToOneWordAtLine {
    private static void divide() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/TransportationCNNText.tsv"));
//        String filePath = "C:/Users/Jakovcheski/Desktop/All3DomainsWithTop300LinksTextWithSameProcessedLinksOnAbstract.ttl";
        String filePath = "C:\\Users\\Jakovcheski\\Desktop\\TransportationCNNText.txt";
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split(" ?(?<!\\G)((?<=[^\\p{Punct}])(?=\\p{Punct})|\\b) ?");
                for (String word : words) {
                    bw.write(word + "\tO\n");
                    bw.flush();
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            divide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}