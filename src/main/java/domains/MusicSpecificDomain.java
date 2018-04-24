package domains;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MusicSpecificDomain {
    public static void specifyDomain() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Jakovcheski/Desktop/MusicSpecifyDomainWithTop40Links.tsv"));
        String filePath = "C:\\Users\\Jakovcheski\\Desktop\\MusicDomainWithTop40Links.ttl";
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split("\\s");
                if (splittedLine[1].equals("MusicalArtist") || splittedLine[1].equals("musicBand") || splittedLine[1].equals("numberOfAlbums")
                        || splittedLine[1].equals("BackScene") || splittedLine[1].equals("numberOfStudioAlbums") || splittedLine[1].equals("numberOfLiveAlbums")
                        || splittedLine[1].equals("ClassicalMusicArtist") || splittedLine[1].equals("Instrumentalist") || splittedLine[1].equals("Guitarist")
                        || splittedLine[1].equals("MusicDirector") || splittedLine[1].equals("Singer") || splittedLine[1].equals("MusicComposer")
                        || splittedLine[1].equals("SongWriter") || splittedLine[1].equals("MusicFestival") || splittedLine[1].equals("MusicGenre")
                        || splittedLine[1].equals("MusicalWork") || splittedLine[1].equals("artist") || splittedLine[1].equals("Artist")
                        || splittedLine[1].equals("musicComposer") || splittedLine[1].equals("lyrics") || splittedLine[1].equals("Album")
                        || splittedLine[1].equals("compiler") || splittedLine[1].equals("musicFormat") || splittedLine[1].equals("ArtistDiscography")
                        || splittedLine[1].equals("ClassicalMusicComposition") || splittedLine[1].equals("Musical") || splittedLine[1].equals("NationalAnthem")
                        || splittedLine[1].equals("Opera") || splittedLine[1].equals("libretto") || splittedLine[1].equals("Single")
                        || splittedLine[1].equals("Song") || splittedLine[1].equals("EurovisionSongContestEntry") || splittedLine[1].equals("Band")
                        || splittedLine[1].equals("bandMember ")
                        ) {
                    bw.write(splittedLine[0] + "\tMUSIC\n");
                    bw.flush();
                } else {
                    bw.write(splittedLine[0] + "\tO\n");
                    bw.flush();
                }
            }
        } catch (IOException e) {
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
            specifyDomain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
