import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilihan Bangun Datar: ");
        System.out.println("[1] Bola");
        System.out.println("[2] Kubus");
        System.out.println("[3] Lingkaran");
        System.out.println("[4] Segi");
        System.out.println("[5] Tabung");
        System.out.println("[6] Trapesium");

        System.out.print("Masukkan pilihan Anda: ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1: // Bola
                System.out.print("Masukkan diameter bola: ");
                double diameterBola = scanner.nextDouble();
                Bola bola = new Bola("Bola", diameterBola);

                // Cetak luas dan volume bola
                System.out.println("Luas bola: " + bola.hitungLuas());
                System.out.println("Volume bola: " + bola.hitungVolume());
                break;

            case 2: // Kubus
                System.out.print("Masukkan sisi kubus: ");
                double sisiKubus = scanner.nextDouble();
                Kubus kubus = new Kubus("Kubus", sisiKubus);

                // Cetak luas dan volume kubus
                System.out.println("Luas kubus: " + kubus.hitungLuas());
                System.out.println("Volume kubus: " + kubus.hitungVolume());
                break;

            case 3: // Lingkaran
                System.out.print("Masukkan diameter lingkaran: ");
                double diameterLingkaran = scanner.nextDouble();
                Lingkaran lingkaran = new Lingkaran("Lingkaran", diameterLingkaran);

                // Cetak luas lingkaran
                System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());
                break;

            case 4: // Segi
                System.out.print("Apakah Anda ingin menghitung persegi panjang? (Y/N): ");
                String isPersegiPanjang = scanner.next();

                if (isPersegiPanjang.equalsIgnoreCase("Y")) {
                    System.out.print("Masukkan panjang persegi panjang: ");
                    double panjangPersegiPanjang = scanner.nextDouble();
                    System.out.print("Masukkan lebar persegi panjang: ");
                    double lebarPersegiPanjang = scanner.nextDouble();

                    Segi segi = new Segi("Persegi Panjang", panjangPersegiPanjang, lebarPersegiPanjang, 4, 4);

                    // Cetak luas segi
                    System.out.println("Luas segi: " + segi.hitungLuas());

                    // Cetak keliling segi
                    System.out.println("Keliling segi: " + segi.hitungKeliling());
                } else {
                    System.out.print("Masukkan panjang segi: ");
                    double panjangSegi = scanner.nextDouble();
                    System.out.print("Masukkan lebar segi: ");
                    double lebarSegi = scanner.nextDouble();
                    System.out.print("Masukkan sisi segi: ");
                    double sisiSegi = scanner.nextDouble();
                    System.out.print("Masukkan jumlah sisi segi: ");
                    double jumlahSisiSegi = scanner.nextDouble();

                    Segi segi = new Segi("Segi", panjangSegi, lebarSegi, sisiSegi, jumlahSisiSegi);

                    // Cetak luas segi
                    System.out.println("Luas segi: " + segi.hitungLuas());

                    // Cetak keliling segi
                    System.out.println("Keliling segi: " + segi.hitungKeliling());
                }
                break;

            case 5: // Tabung
                System.out.print("Masukkan diameter tabung: ");
                double diameterTabung = scanner.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tinggiTabung = scanner.nextDouble();

                Tabung tabung = new Tabung("Tabung", diameterTabung, tinggiTabung);

                // Cetak luas dan volume tabung
                System.out.println("Luas tabung: " + tabung.hitungLuas());
                System.out.println("Volume tabung: " + tabung.hitungVolume());
                break;

            case 6: // Trapesium
                System.out.print("Masukkan panjang sisi atas trapesium: ");
                double sisiAtasTrapesium = scanner.nextDouble();
                System.out.print("Masukkan panjang sisi bawah trapesium: ");
                double sisiBawahTrapesium = scanner.nextDouble();
                System.out.print("Masukkan panjang sisi samping1 trapesium: ");
                double sisiSamping1Trapesium = scanner.nextDouble();
                System.out.print("Masukkan panjang sisi samping2 trapesium: ");
                double sisiSamping2Trapesium = scanner.nextDouble();
                System.out.print("Masukkan tinggi trapesium: ");
                double tinggiTrapesium = scanner.nextDouble();

                Trapesium trapesium = new Trapesium("Trapesium", sisiAtasTrapesium, sisiBawahTrapesium, sisiSamping1Trapesium, sisiSamping2Trapesium, tinggiTrapesium);

                // Cetak luas dan keliling trapesium
                System.out.println("Luas trapesium: " + trapesium.hitungLuas());
                System.out.println("Keliling trapesium: " + trapesium.hitungKeliling());
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        // Tutup scanner
        scanner.close();
    }
}
