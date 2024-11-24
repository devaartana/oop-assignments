import java.util.ArrayList;
import java.util.List;

public class Simulator {
  private Field field;
  private List<Animal> animals;

  public Simulator(int depth, int width) {
    field = new Field(depth, width);
    animals = new ArrayList<>();
    populate();
  }

  public void simulate(int steps) {
    for (int step = 0; step < steps; step++) {
      List<Animal> newAnimals = new ArrayList<>();

      for (Animal animal : animals) {
        animal.act(newAnimals);
      }

      animals.addAll(newAnimals);

      int rabbitCount = 0;
      int foxCount = 0;

      for (Animal animal : animals) {
        if (animal instanceof Rabbit) {
          rabbitCount++;
        } else if (animal instanceof Fox) {
          foxCount++;
        }
      }

      System.out.println("Step " + (step + 1) + ":");
      System.out.println("Rabbits: " + rabbitCount);
      System.out.println("Foxes: " + foxCount);
    }
  }

  private void populate() {
    for (int i = 0; i < 10; i++) {
      Location location = getRandomFreeLocation();
      if (location != null) {
        Rabbit rabbit = new Rabbit(field, location);
        animals.add(rabbit);
        field.place(rabbit, location);
      }

      location = getRandomFreeLocation();
      if (location != null) {
        Fox fox = new Fox(field, location);
        animals.add(fox);
        field.place(fox, location);
      }
    }
  }

  private Location getRandomFreeLocation() {
    int depth = field.getDepth();
    int width = field.getWidth();

    for (int i = 0; i < depth * width; i++) {
      int row = (int) (Math.random() * depth);
      int col = (int) (Math.random() * width);
      Location location = new Location(row, col);

      if (field.getObjectAt(location) == null) {
        return location;
      }
    }
    return null;
  }
}
