package music;

import track.*;
import java.util.ArrayList;

public class MusicOrganizer {
    private ArrayList<Track> tracks;
    private MusicPlayer player;
    private TrackReader reader;
    
    public MusicOrganizer() {
        tracks = new ArrayList<Track>();
        player = new MusicPlayer();
        reader = new TrackReader();
        readLibrary("audio");
        System.out.println("Music library loaded. " + getNumberOfTracks() + " tracks.");
    }

    public void listAllTracks() {
        System.out.println("Track listing: ");
        for (int i = 0; i < tracks.size(); i++) {
            Track track = tracks.get(i);
            System.out.println((i + 1) + ". " + track.getDetails());
        }
        System.out.println();
    }

    public void playTrack(int index) {
        if (indexValid(index)) {
            Track track = tracks.get(index);
            player.startPlaying(track.getFilename());
            System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
            System.out.println("");
        }
    }
    
    public void stopTrack() {
        player.stopPlaying(); 
        System.out.println("");
    }

    private void readLibrary(String folder) {
        tracks = reader.readTracks(folder);
    }

    public int getNumberOfTracks() {
        return tracks.size();
    }

    private boolean indexValid(int index) {
        return index >= 0 && index < tracks.size();
    }
}
