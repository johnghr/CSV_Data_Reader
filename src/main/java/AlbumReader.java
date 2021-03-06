import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class AlbumReader {

    public static LinkedHashMap<String,Album> readAlbums(File file) {
        LinkedHashMap<String,Album> albumLinkedHashMap = new LinkedHashMap<>();

        //Create an instance of scanner
        try (Scanner scanner = new Scanner(file)) {

            //Get all tokens and store them
            while (scanner.hasNextLine()) {
                //Scan a line in csv and assign it to variable while moving on to next string
                String line = scanner.nextLine();
                //Delimit line with comma and assign the result to csvValues String array
                String[] csvValues = line.split(",");

                String uuid = csvValues[0];
                String albumTitle = csvValues[1];
                String artist = csvValues[2];
                String yearReleased = csvValues[3];
                //construct album instances using csvValues stored in variables
                Album album = new Album(uuid, albumTitle, artist, yearReleased);
                //Store album as LinkedHasMap using uuid as key
                albumLinkedHashMap.put(album.getUuid(), album);

            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return albumLinkedHashMap;
    }

}