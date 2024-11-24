import java.util.List;

public class Fox extends Animal {
  public Fox(Field field, Location location) {
    super(field, location);
  }

  @Override
  public void act(List<Animal> newAnimals) {
    if (isAlive()) {
      Location newLocation = findFood();

      if (newLocation == null) {
        newLocation = getField().freeAdjecentLocation(getLocation());
      }

      if (Math.random() < 0.03 && newLocation != null) {
        Location freeLocation = getField().freeAdjecentLocation(getLocation());
        if (freeLocation != null) {
          newAnimals.add(new Fox(getField(), freeLocation));
        }
      }

      if (newLocation != null) {
        setLocation(newLocation);
      } else {
        setDead();
      }
    }
  }

  private Location findFood() {
    List<Location> adjacent = getField().adjacentLocations(getLocation());

    for (Location loc : adjacent) {
      Object animal = getField().getObjectAt(loc);
      if (animal instanceof Rabbit) {
        Rabbit rabbit = (Rabbit) animal;
        rabbit.setDead();
        return loc;
      }
    }

    return null;
  }
}
