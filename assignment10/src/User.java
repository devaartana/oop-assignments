import java.util.ArrayList;
import java.util.List;

public class User {
  private String username;
  private List<Post> posts;

  public User(String username) {
    this.username = username;
    this.posts = new ArrayList<>();
  }

  public String getUsername() {
    return username;
  }

  public void addMessagePost(String content) {
    Post post = new MessagePost(this, content);
    posts.add(post);
    System.out.println(username + " posted a message: " + content);
  }

  public void addPhotoPost(String filename, String caption) {
    Post post = new PhotoPost(this, filename, caption);
    posts.add(post);
    System.out.println(username + " posted a photo: " + filename + " with caption: " + caption);
  }

  public void likePost(Post post) {
    post.addLike(this);
  }

  public List<Post> getPosts() {
    return posts;
  }
}