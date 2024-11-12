public class TicketReservationSystem {
  public static void main(String[] args) {
    Ticket economyTicket = 
      new EconomyTicket("Nyoman Lengur", "Surabaya - Bali", 1000000);
    Ticket businessTicket = 
      new BusinessTicket("Ketut Pakok", "Surabaya - Singapore", 3000000);
    Ticket firstClassTicket = 
      new FirstClassTicket("Putu James", "Surabaya - Jepang", 15000000);

    economyTicket.displayTicketDetails();
    businessTicket.displayTicketDetails();
    firstClassTicket.displayTicketDetails();
  }
}