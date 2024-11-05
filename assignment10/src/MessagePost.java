import java.time.format.DateTimeFormatter;

public class MessagePost extends Post {
  private String message;

  public MessagePost(User author, String message) {
    super(author);
    this.message = message;
  }

  public String getText() {
    return message;
  }

  @Override
  public void showPost() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formattedTimestamp = getTimestamp().format(formatter);

    System.out.println(getAuthor().getUsername() + " posted at " + formattedTimestamp + ": " + message + " - Likes: "
        + getLikeCount());
  }
}
