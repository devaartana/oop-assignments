// Abstract class
abstract class Mahasiswa {
  public String nama;
  public String nrp;
  public int angkatan;

  // Encapsulation dengan membuat data menjadi private, hanya method dalam class
  // yang bisa ngambil data
  private boolean lulus;

  // Constructor
  public Mahasiswa(String nama, String nrp, int angkatan, boolean lulus) {
    this.nama = nama;
    this.nrp = nrp;
    this.angkatan = angkatan;
    this.lulus = lulus;
  }

  // Polymorphism
  public void tampilkanInfo() {
    System.out.println("Nama: " + nama);
    System.out.println("NRP: " + nrp);
    System.out.println("Angkatan: " + angkatan);
  }

  // Encapsulation: method yang bisa ngambil data private
  public String isLulus() { return (lulus) ? "Lulus" : "Belum lulus"; }

  public void tampilkanInfo(boolean all) {
    System.out.println("Nama: " + nama);
    System.out.println("NRP: " + nrp);
    System.out.println("Angkatan: " + angkatan);
    System.out.println("Status kelulusan: " + isLulus());
  }
}

// Inheritance
class MahasiswaSistemInformasi extends Mahasiswa {
  // Constructor manggil punya class asli
  public MahasiswaSistemInformasi(String nama, String nrp, int angkatan,
                                  boolean lulus) {
    super(nama, nrp, angkatan, lulus);
  }

  // Polymorphism(Overriding)
  @Override
  public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Jurusan: Sistem Informasi");
  }
  @Override
  public void tampilkanInfo(boolean all) {
    super.tampilkanInfo(all);
    System.out.println("Jurusan: Sistem Informasi");
  }
}

// Inheritance
class MahasiswaInformatika extends Mahasiswa {
  // Constructor manggil punya class asli
  public MahasiswaInformatika(String nama, String nrp, int angkatan,
                              boolean lulus) {
    super(nama, nrp, angkatan, lulus);
  }

  // Polymorphism(Overriding)
  @Override
  public void tampilkanInfo() {
    super.tampilkanInfo();
    System.out.println("Jurusan: Teknik Informatika");
  }
  @Override
  public void tampilkanInfo(boolean all) {
    super.tampilkanInfo(all);
    System.out.println("Jurusan: Teknik Informatika");
  }
}

public class Main {
  public static void main(String[] args) {
    // Pembuatan object berdasarkan subclass
    Mahasiswa mahasiswaSI =
        new MahasiswaSistemInformasi("Kadek Arya", "5025231157", 2023, true);
    Mahasiswa mahasiswaTI =
        new MahasiswaInformatika("Deva Artana", "5025231100", 2023, false);

    // Hasil overriding
    System.out.println("Hasil overriding");
    System.out.println("Data subclass Sistem Informasi");
    mahasiswaSI.tampilkanInfo();
    System.out.println("\nData subclass Teknik Informatika");
    mahasiswaTI.tampilkanInfo();

    // Hasil overloading
    System.out.println("\nHasil overloading");
    mahasiswaSI.tampilkanInfo(true);

    // Encapsulation
    System.out.println(
        "\nHasil pemanggilan private data dengan method dalam class ");
    System.out.println(mahasiswaSI.nama + ": " + mahasiswaSI.isLulus());
    System.out.println(mahasiswaTI.nama + ": " + mahasiswaTI.isLulus());
  }
}
