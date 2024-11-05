import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Network network = new Network();

    List<String> userNames = List.of("Alice", "Bob", "Charlie", "Dave", "Eve");
    List<User> users = new ArrayList<>();

    for (String name : userNames) {
      users.add(network.addUser(name));
    }

    users.get(0).addMessagePost("Hello, this is Alice's first message post!");
    users.get(0).addPhotoPost("http://example.com/alice_photo.jpg", "A lovely day out!");

    users.get(1).addMessagePost("Hi everyone, Bob here!");
    users.get(1).addMessagePost("Loving this network!");
    users.get(1).addPhotoPost("http://example.com/bob_hiking.jpg", "Ready for a hike tomorrow!");

    users.get(2).addMessagePost("Hey, Charlie's in the house!");
    users.get(2).addPhotoPost("http://example.com/charlie_code.jpg", "Coding in Java is fun!");

    users.get(3).addMessagePost("Dave joined the network.");
    users.get(3).addPhotoPost("http://example.com/dave_book.jpg", "Just finished a book on Java!");

    users.get(4).addMessagePost("Hello from Eve!");
    users.get(4).addPhotoPost("http://example.com/eve_workout.jpg", "Just finished a workout.");

    for (User user : users) {
      for (Post post : user.getPosts()) {
        network.addPost(post);
      }
    }

    network.showAllPost();
  }
}
