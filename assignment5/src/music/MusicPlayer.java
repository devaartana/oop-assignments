package music;

public class MusicPlayer {
    private boolean isPlaying;

    public MusicPlayer() {
        isPlaying = false;
    }

    public void startPlaying(String filename) {
        System.out.println("Playing file: " + filename);
        isPlaying = true;
    }

    public void stopPlaying() {
        if (isPlaying) {
            System.out.println("Stopping the current track.");
            isPlaying = false;
        } else {
            System.out.println("No track is currently playing.");
        }
    }

    public boolean getMusicPlayerStatus() {
        return isPlaying;
    }
}
