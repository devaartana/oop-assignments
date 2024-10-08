import java.util.HashMap;
import java.util.Map;

public class Responder {
  private Map<String, String> responses;

  public Responder() {
    responses = new HashMap<>();
    responses.put("crash", "Crashes happen due to multiple factors. What were you doing before it crashed?");
    responses.put("slow",
        "I think the system is slow because you have many programs running, try closing extra programs or rebooting.");
    responses.put("error", "Could you send the error message that you're seeing?");
    responses.put("install", "If the installation failed, check the version and available disk space.");
    responses.put("thank", "You're welcome! If you have any more issues, feel free to reach out!");
  }

  public String generateResponse(String input) {
    for (String keyword : responses.keySet()) {
      if (input.toLowerCase().contains(keyword)) {
        return responses.get(keyword);
      }
    }
    return "That sounds interesting. Tell me more...";
  }
}
