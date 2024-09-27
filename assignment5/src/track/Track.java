package track;

public class Track {
  private String filename;
  private String artist;
  private String title;

  public Track(String filename, String artist, String title) {
    this.filename = filename;
    this.artist = artist;
    this.title = title;
  }

  public String getFilename() {
    return filename;
  }

  public String getArtist() {
    return artist;
  }

  public String getTitle() {
    return title;
  }

  public String getDetails() {
    return artist + " - " + title;
  }
}
