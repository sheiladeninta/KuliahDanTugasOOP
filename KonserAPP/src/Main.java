import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private Database database;
    private User user;

    public Main() {
        scanner = new Scanner(System.in);
        database = new Database();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

    public void showMenu() {
        System.out.println("Selamat datang di aplikasi konser");
        System.out.println("Silahkan register terlebih dahulu");
        System.out.println("=========================");

        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("No. HP: ");
        String noHP = scanner.nextLine();

        user = new User(nama, noHP);

        System.out.println("=========================");
        System.out.println("Register berhasil!");
        System.out.println("Nama: " + user.getName());
        System.out.println("No. HP: " + user.getNoHP());
        System.out.println("=========================");

        int choice;
        do {
            System.out.println("Pilih menu:");
            System.out.println("1. Menu jenis konser");
            System.out.println("2. Beli tiket");
            System.out.println("3. Keluar");
            System.out.println("=========================");
            System.out.print("Silahkan pilih menu: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showConcertMenu();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        } while (choice != 3);
    }

    public void showConcertMenu() {
        System.out.println("Daftar konser yang tersedia:");
        int index = 1;
        for (Konser konser : database.getKonserList()) {
            System.out.println(index + ". " + konser.getNamaBand());
            System.out.println("Tanggal konser: " + konser.getTanggal());
            System.out.println("Harga tiket: " + konser.getHargaTiket());
            System.out.println("Lokasi: " + konser.getLokasi());
            System.out.println();
            index++;
        }
    }

    public void buyTicket() {
        System.out.print("Pilih nomor konser yang akan dipilih: ");
        int concertChoice = Integer.parseInt(scanner.nextLine());

        System.out.print("Jumlah tiket: ");
        int jumlahTiket = Integer.parseInt(scanner.nextLine());

        Konser selectedConcert = database.getKonserList().get(concertChoice - 1);
        int totalHarga = selectedConcert.getHargaTiket() * jumlahTiket;

        System.out.println("=========================");
        System.out.println("Selamat Anda berhasil membeli tiket konser " + selectedConcert.getNamaBand() + "!");
        System.out.println("Jumlah tiket yang dibeli: " + jumlahTiket);
        System.out.println("Total Harga: " + totalHarga);
        System.out.println("=========================");
    }
}
