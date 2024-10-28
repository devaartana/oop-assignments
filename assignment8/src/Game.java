public class Game {
  private Parser parser;
  private Room currentRoom;

  public Game() {
    createRooms();
    parser = new Parser();
  }

  private void createRooms() {
    Room outside, theatre, pub, lab, office, library, cafeteria, dormitory, gym, garden, computerLab, lectureHall;

    outside = new Room(
        "You are standing outside the main entrance of the university. There's a small garden and a pathway leading to different buildings.");
    theatre = new Room("You are in the campus theatre. Rows of seats face a large stage, and the curtains are drawn.");
    pub = new Room(
        "You are in the campus pub. It's a cozy place with wooden tables, a bar counter, and a dartboard in the corner.");
    lab = new Room(
        "You are in a research lab. There are various scientific instruments, computers, and chemical containers scattered around.");
    office = new Room(
        "You are in an office. There’s a desk covered in papers, a computer, and a bookshelf filled with reference books.");
    library = new Room(
        "You are in the university library. Shelves filled with books stretch as far as the eye can see, and there's a quiet reading area.");
    cafeteria = new Room(
        "You are in the cafeteria. The aroma of food fills the air, and there are tables and chairs for students to enjoy their meals.");
    dormitory = new Room(
        "You are in a dormitory. Rows of bunk beds are lined up, and personal belongings are scattered around.");
    gym = new Room(
        "You are in the gym. There are various workout equipment, and a basketball court at the far end.");
    garden = new Room(
        "You are in a beautiful garden filled with various flowers and a small pond in the center. It's a peaceful place to relax.");
    computerLab = new Room(
        "You are in the computer lab. Rows of computers line the room, and students are busy working on their assignments.");
    lectureHall = new Room(
        "You are in a lecture hall. Rows of seats face a podium and a large whiteboard, where lectures are given.");

    outside.setExits(null, theatre, lab, pub);
    theatre.setExits(null, lectureHall, null, outside);
    pub.setExits(null, outside, cafeteria, null);
    lab.setExits(outside, office, computerLab, library);
    office.setExits(null, null, null, lab);
    library.setExits(null, lab, dormitory, garden);
    cafeteria.setExits(pub, dormitory, null, null);
    dormitory.setExits(library, gym, null, cafeteria);
    gym.setExits(null, null, null, dormitory);
    garden.setExits(null, library, null, null);
    computerLab.setExits(lab, lectureHall, null, null);
    lectureHall.setExits(null, null, computerLab, theatre);

    currentRoom = outside; 
  }

  public void play() {
    printWelcome();

    boolean finished = false;
    while (!finished) {
      Command command = parser.getCommand();
      finished = processCommand(command);
    }

    System.out.println("Thank you for playing. Good bye.");
  }

  private void printWelcome() {
    System.out.println("Welcome to the World of Zull!");
    System.out.println("An exciting adventure awaits you.");
    System.out.println("Explore the various locations, solve puzzles, and uncover secrets.");
    System.out.println("Type 'help' if you need assistance.");
    System.out.println();
    System.out.println("You are " + currentRoom.getDescription());
    System.out.print("Exits: ");
    if (currentRoom.northExit != null)
      System.out.print("north ");
    if (currentRoom.eastExit != null)
      System.out.print("east ");
    if (currentRoom.southExit != null)
      System.out.print("south ");
    if (currentRoom.westExit != null)
      System.out.print("west ");
    System.out.println();
  }

  private boolean processCommand(Command command) {
    boolean wantToQuit = false;
    if (command.isUnknown()) {
      System.out.println("I don't know what you mean...");
      return false;
    }

    String commandWord = command.getCommandWord();
    if (commandWord.equals("help"))
      printHelp();
    else if (commandWord.equals("go"))
      goRoom(command);
    else if (commandWord.equals("quit"))
      wantToQuit = quit(command);

    return wantToQuit;
  }

  private void printHelp() {
    System.out.println("You are lost. You are alone. You wander");
    System.out.println("around at the university.");
    System.out.println("Your command words are:");
    System.out.println("   go quit help");
  }

  private void goRoom(Command command) {
    if (!command.hasSecondWord()) {
      System.out.println("Go where?");
      return;
    }

    String direction = command.getSecondWord();
    Room nextRoom = null;
    if (direction.equals("north"))
      nextRoom = currentRoom.northExit;
    if (direction.equals("east"))
      nextRoom = currentRoom.eastExit;
    if (direction.equals("south"))
      nextRoom = currentRoom.southExit;
    if (direction.equals("west"))
      nextRoom = currentRoom.westExit;

    if (nextRoom == null) {
      System.out.println("There is no door!");
    } else {
      currentRoom = nextRoom;
      System.out.println("You are " + currentRoom.getDescription());
      System.out.print("Exits: ");
      if (currentRoom.northExit != null)
        System.out.print("north ");
      if (currentRoom.eastExit != null)
        System.out.print("east ");
      if (currentRoom.southExit != null)
        System.out.print("south ");
      if (currentRoom.westExit != null)
        System.out.print("west ");
      System.out.println();
    }
  }

  private boolean quit(Command command) {
    if (command.hasSecondWord()) {
      System.out.println("Quit what?");
      return false;
    } else {
      return true;
    }
  }

}
