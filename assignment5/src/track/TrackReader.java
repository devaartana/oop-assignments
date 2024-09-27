package track;

import java.io.File;
import java.util.ArrayList;

public class TrackReader {

    public ArrayList<Track> readTracks(String folderPath) {
        ArrayList<Track> tracks = new ArrayList<>();

        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String filename = file.getName();
                    String artist = filename.substring(filename.lastIndexOf('-') + 1, filename.lastIndexOf('.'));
                    String title = filename.substring(0, filename.lastIndexOf('-'));
                    tracks.add(new Track(filename, artist, title));
                }
            }
        } else {
            System.out.println("File MP3 not found.");
        }

        return tracks;
    }
}
