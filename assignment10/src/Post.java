import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Post {
  private User author;
  private LocalDateTime timestamp;
  private List<User> likes;

  public Post(User author) {
    this.author = author;
    this.timestamp = LocalDateTime.now();
    this.likes = new ArrayList<>();
  }

  public User getAuthor() {
    return author;
  }

  public List<User> getLikes() {
    return likes;
  }

  public void addLike(User user) {
    if (likes.contains(user)) {
      likes.add(user);
      System.out.println(user.getUsername() + " liked this post");
    }
  }

  public void removeLike(User user) {
    if (likes.contains(user)) {
      likes.remove(user);
      System.out.println(user.getUsername() + " unliked this post");
    }
  }

  public int getLikeCount() {
    return likes.size();
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public abstract void showPost();
}
