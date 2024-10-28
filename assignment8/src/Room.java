public class Room {
  public String description;
  public Room northExit, eastExit, southExit,  westExit;

  public Room(String description) {
    this.description = description;
  }

  public void setExits(Room north, Room south, Room east, Room west) {
    if (north != null)
      northExit = north;
    if (south != null)
      southExit = south;
    if (east != null)
      eastExit = east;
    if (west != null)
      westExit = west;
  }

  public String getDescription() {
    return this.description;
  }
}
