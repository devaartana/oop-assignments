import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    try {
      SupportSystem supportSystem = new SupportSystem(); 
      supportSystem.start();
    } catch (IOException e) {
      System.out.println("IO erorr");
      e.printStackTrace();
    }
  }
}
