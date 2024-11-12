class FirstClassTicket extends Ticket {
  private double discount = 0.50; 

  public FirstClassTicket(String passengerName, String destination, double basePrice) {
    super(passengerName, destination, basePrice);
  }

  @Override
  public double calculateFare() {
    return basePrice * (1 + discount);
  }

  @Override
  public String getClassType() {
    return "First Class";
  }

  @Override
  public int getBaggageLimit() {
    return 40; 
  }

  @Override
  public String[] getFacilities() {
    return new String[] {
        "Menu makanan pribadi",
        "Bar pribadi",
        "Suite pribadi",
        "Shower spa",
        "Concierge service",
        "Prioritas utama check-in"
    };
  }
}