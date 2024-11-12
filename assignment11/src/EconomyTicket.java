class EconomyTicket extends Ticket {
  private double discount = 0.10;

  public EconomyTicket(String passengerName, String destination, double basePrice) {
    super(passengerName, destination, basePrice);
  }

  @Override
  public double calculateFare() {
    return basePrice * (1 - discount);
  }

  @Override
  public String getClassType() {
    return "Ekonomi";
  }

  @Override
  public int getBaggageLimit() {
    return 20; 
  }

  @Override
  public String[] getFacilities() {
    return new String[] {
      "Makanan ringan",
      "Air mineral",
      "Majalah penerbangan"
    };
  }
}
