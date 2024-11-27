public class NonFloweringPlant extends Plant {
  public NonFloweringPlant(String name) {
    super(name);
  }

  @Override
  public void grow(){
    System.out.println(getName() + "is growing wihtout producing flowers.");
  }

  @Override
  public void photosynthesize(){
    System.out.println(getName() + "is photosynthesis without flowers.");
  }
}