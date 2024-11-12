class BusinessTicket extends Ticket {
  private double discount = 0.25; 

  public BusinessTicket(String passengerName, String destination, double basePrice) {
    super(passengerName, destination, basePrice);
  }

  @Override
  public double calculateFare() {
    return basePrice * (1 + discount);
  }

  @Override
  public String getClassType() {
    return "Bisnis";
  }

  @Override
  public int getBaggageLimit() {
    return 30; 
  }

  @Override
  public String[] getFacilities() {
    return new String[] {
        "Makanan premium",
        "Minuman beralkohol",
        "Kursi yang lebih luas",
        "Lounge akses",
        "Prioritas check-in"
    };
  }
}