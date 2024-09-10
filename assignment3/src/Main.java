public class Main {
  public static void main(String[] args) {
    // Membuat instance dari TicketMachine dengan harga 100
    TicketMachine machine = new TicketMachine(100);

    // Menguji berbagai metode
    System.out.println("Price: " + machine.getPrice()); // Output: 100
    System.out.println("Balance: " + machine.getBalance()); // Output: 0

    // Menambah uang ke dalam mesin
    machine.insertMoney(50); // Seharusnya tidak cukup untuk membeli tiket
    System.out.println("Balance after inserting 50: " + machine.getBalance()); // Output: 50

    // Mencoba untuk mencetak tiket (tidak berhasil karena balance kurang)
    machine.printTicket(); // Output: "You must insert at least 50 more cents."

    // Menambah uang lagi
    machine.insertMoney(100);
    machine.printTicket(); // Berhasil mencetak tiket

    // Refund balance yang tersisa
    System.out.println("Refunding balance: " + machine.refundBalance()); // Output: 50 (karena sudah membeli tiket
                                                                         // seharga 100)
  }
}
