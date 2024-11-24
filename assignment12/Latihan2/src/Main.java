public class Main {
  public static void main(String[] args) {
    int fieldDepth = 20;
    int fieldWidth = 20;

    Simulator simulator = new Simulator(fieldDepth, fieldWidth);

    int steps = 50;
    System.out.println("Starting simulation for " + steps + " steps...");
    simulator.simulate(steps);

    System.out.println("Simulation completed.");
  }
}
