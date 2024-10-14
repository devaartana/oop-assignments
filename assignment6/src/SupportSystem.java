import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SupportSystem {
  private InputReader reader;
  private Responder responder;
  private FileWriter writer;
  private DateTimeFormatter dtf;

  public SupportSystem() throws IOException {
    reader = new InputReader();
    responder = new Responder();
    writer = new FileWriter("history.txt", true); 
    dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
  }

  public void start() {
    System.out.println("Welcome to the DodgySoft Technical Support System.\n");
    System.out.println("Please tell us about your problem.");
    System.out.println("We will assist you with any problem you might have.");
    System.out.println("Please type 'bye' to exit our system.");

    while (true) {
      String input = reader.getInput();
      if (input.equalsIgnoreCase("bye")) {
        break;
      }

      String response = responder.generateResponse(input);
      System.out.println(response);

      saveConversation(input, response);
    }

    System.out.println("Thank you, Goodbye!");

    try {
      writer.close(); 
    } catch (IOException e) {
      System.out.println("Error closing.");
    }
  }

  private void saveConversation(String input, String response) {
    try {
      LocalDateTime now = LocalDateTime.now();
      writer.write("Timestamp: " + dtf.format(now));
      writer.write(System.lineSeparator());
      writer.write("User: " + input);
      writer.write(System.lineSeparator());
      writer.write("System: " + response);
      writer.write(System.lineSeparator());
      writer.write(System.lineSeparator());
    } catch (IOException e) {
      System.out.println("Error writing.");
    }
  }
}
