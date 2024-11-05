import java.time.format.DateTimeFormatter;

public class PhotoPost extends Post {
  private String filename;
  private String caption;

  public PhotoPost(User author, String filename, String caption) {
    super(author);
    this.filename = filename;
    this.caption = caption;
  }

  public String getFilename() {
    return filename;
  }

  public String getCaption() {
    return caption;
  }

  @Override
  public void showPost() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTimestamp = getTimestamp().format(formatter);

    System.out.println(getAuthor().getUsername() + " posted a photo at " + formattedTimestamp + ": " + filename
        + " - Caption: " + caption + " - Likes: " + getLikeCount());
  }
}
