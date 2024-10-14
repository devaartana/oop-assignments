import java.util.HashMap;
import java.util.Map;

public class Responder {
  private Map<String, String> responses;
  private Map<String, String> defaultResponses;

  public Responder() {
    responses = new HashMap<>();
    responses.put("crash", "Crashes happen due to multiple factors. What were you doing before it crashed?");
    responses.put("slow",
        "I think the system is slow because you have many programs running. Try closing extra programs or rebooting.");
    responses.put("error", "Could you send the error message that you're seeing?");
    responses.put("install", "If the installation failed, check the version and available disk space.");
    responses.put("thank", "You're welcome! If you have any more issues, feel free to reach out!");

    defaultResponses = new HashMap<>();
    defaultResponses.put("performance",
        "It might be a performance issue. Have you tried restarting or closing other programs?");
    defaultResponses.put("installation",
        "For installation issues, make sure you're using the correct version and have enough disk space.");
    defaultResponses.put("network",
        "This seems like a network-related issue. Have you checked your internet connection?");
    defaultResponses.put("hardware",
        "It could be related to hardware. Have you tried restarting the device or checking for overheating?");
    defaultResponses.put("software",
        "There might be a software conflict. Try reinstalling the application or updating it to the latest version.");
    defaultResponses.put("account",
        "For account-related issues, please check if your credentials are correct or try resetting your password.");
    defaultResponses.put("login",
        "If you're having trouble logging in, verify your username and password, or try resetting your credentials.");
  }

  public String generateResponse(String input) {
    for (String keyword : responses.keySet()) {
      if (input.toLowerCase().contains(keyword)) {
        return responses.get(keyword);
      }
    }
    return checkDefaultResponse(input);
  }

  private String checkDefaultResponse(String input) {
    String lowerInput = input.toLowerCase();
    
    if (lowerInput.contains("software") || lowerInput.contains("app") || lowerInput.contains("application")
        || lowerInput.contains("program")) {
      return defaultResponses.get("software");
    }

    if (lowerInput.contains("hardware") || lowerInput.contains("overheat") || lowerInput.contains("fan")
        || lowerInput.contains("temperature")) {
      return defaultResponses.get("hardware");
    }

    if (lowerInput.contains("lag") || lowerInput.contains("freeze")) {
      return defaultResponses.get("performance");
    }

    if (lowerInput.contains("setup") || lowerInput.contains("update")) {
      return defaultResponses.get("installation");
    }

    if (lowerInput.contains("network") || lowerInput.contains("internet") || lowerInput.contains("wifi")
        || lowerInput.contains("connection")) {
      return defaultResponses.get("network");
    }

    if (lowerInput.contains("account") || lowerInput.contains("password") || lowerInput.contains("username")) {
      return defaultResponses.get("account");
    }

    if (lowerInput.contains("login") || lowerInput.contains("signin") || lowerInput.contains("sign in")) {
      return defaultResponses.get("login");
    }

    return "That sounds interesting. Tell me more...";
  }
}
