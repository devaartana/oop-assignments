public class SupportSystem {
  private InputReader reader;
  private Responder responder;

  public SupportSystem() {
    reader = new InputReader();
    responder = new Responder();
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
    }

    System.out.println("Thank you, Goodbye!");
  }
}
