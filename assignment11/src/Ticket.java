abstract class Ticket {
  protected String passengerName;
  protected String destination;
  protected double basePrice;

  public Ticket(String passengerName, String destination, double basePrice) {
    this.passengerName = passengerName;
    this.destination = destination;
    this.basePrice = basePrice;
  }

  public abstract double calculateFare();
  public abstract String getClassType();
  public abstract int getBaggageLimit();
  public abstract String[] getFacilities();

  public String getPassengerName() {
    return passengerName;
  }

  public String getDestination() {
    return destination;
  }

  public double getBasePrice() {
    return basePrice;
  }

  public void displayTicketDetails() {
    System.out.println("\n====== Detail Tiket ======");
    System.out.println("Nama Penumpang: " + passengerName);
    System.out.println("Tujuan: " + destination);
    System.out.println("Kelas: " + getClassType());
    System.out.println("Harga Dasar: Rp " + basePrice);
    System.out.println("Harga Akhir: Rp " + calculateFare());
    System.out.println("Batas Bagasi: " + getBaggageLimit() + " kg");
    System.out.println("Fasilitas:");
    for (String facility : getFacilities()) {
      System.out.println("- " + facility);
    }
  }
}
