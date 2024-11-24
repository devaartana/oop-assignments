import java.util.List;

public class Rabbit extends Animal {
  public Rabbit(Field field, Location location) {
    super(field, location);
  }

  @Override
  public void act(List<Animal> newAnimals) {
    if (isAlive()) {
      Location newLocation = getField().freeAdjecentLocation(getLocation());

      if (Math.random() < 0.18 && newLocation != null) {
        Location freeLocation = getField().freeAdjecentLocation(getLocation());
        if (freeLocation != null) {
          newAnimals.add(new Rabbit(getField(), freeLocation));
        }
      }

      if (newLocation != null) {
        setLocation(newLocation);
      } else {
        setDead();
      }
    }
  }
}
