public abstract class Animal extends LivingBeing{
  public Animal(String name) {
    super(name);
  }

  public abstract void grow();
  public abstract void move();
}
