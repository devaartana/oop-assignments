import java.util.List;
import java.util.ArrayList;

public class Field {
  private Object[][] field;

  public Field(int depth, int width) {
    field = new Object[depth][width];
  }

  public int getDepth() {
    return field.length;
  }

  public int getWidth() {
    return field[0].length;
  }

  public void clear(Location location) {
    field[location.getRow()][location.getCol()] = null;
  }

  public void place(Object object, Location location) {
    field[location.getRow()][location.getCol()] = object;
  }

  public Object getObjectAt(Location location) {
    return field[location.getRow()][location.getCol()];
  }

  public Location freeAdjecentLocation(Location location) {
    List<Location> free = new ArrayList<>();
    List<Location> adjacent = adjacentLocations(location);

    for (Location loc : adjacent) {
      if (getObjectAt(loc) == null) {
        free.add(loc);
      }
    }

    return free.isEmpty() ? null : free.get(0);
  }

  public List<Location> adjacentLocations(Location location) {
    List<Location> locations = new ArrayList<>();
    int row = location.getRow();
    int col = location.getCol();
  
    for (int dr = -1; dr <= 1; dr++) {
      for (int dc = -1; dc <= 1; dc++) {
        if (dr != 0 || dc != 0) {
          int newRow = row + dr;
          int newCol = col + dc;
          if (newRow >= 0 && 
              newRow < getDepth() && 
              newCol >= 0 && 
              newCol < getWidth()) {
            locations.add(new Location(newRow, newCol));
          }
        }
      }
    }
    return locations;
  }
  
}
