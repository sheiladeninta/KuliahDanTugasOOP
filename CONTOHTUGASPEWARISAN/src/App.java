import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hitung Bangun Datar dan Bangun Ruang");
        System.out.println("[1] Bola");
        System.out.println("[2] Kubus");
        System.out.println("[3] Lingkaran");
        System.out.println("[4] Segi");
        System.out.println("[5] Tabung");
        System.out.println("[6] Trapesium");

        System.out.print("Masukkan bangun yang ingin dihitung: ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1: // Bola
                System.out.print("Masukkan diameter bola: ");
                double diameterBola = scanner.nextDouble();
                Bola bola = new Bola("Bola", diameterBola);

                System.out.println("Luas bola: " + bola.hitungLuas());
                System.out.println("Volume bola: " + bola.hitungVolume());
                break;

            case 2: // Kubus
                System.out.print("Masukkan sisi kubus: ");
                double sisiKubus = scanner.nextDouble();
                Kubus kubus = new Kubus("Kubus", sisiKubus);

                System.out.println("Luas kubus: " + kubus.hitungLuas());
                System.out.println("Volume kubus: " + kubus.hitungVolume());
                break;

            case 3: // Lingkaran
                System.out.print("Masukkan diameter lingkaran: ");
                double diameterLingkaran = scanner.nextDouble();
                Lingkaran lingkaran = new Lingkaran("Lingkaran", diameterLingkaran);

                System.out.println("Luas lingkaran: " + lingkaran.hitungLuas());
                System.out.println("Luas lingkaran: " + lingkaran.hitungKeliling());
                break;

            case 4: // Segi
                System.out.print("Ingin menghitung persegi panjang atau segi lain? (PP/SL): ");
                String isPersegiPanjang = scanner.next();

                if (isPersegiPanjang.equalsIgnoreCase("PP")) {
                    System.out.print("Masukkan panjang persegi panjang: ");
                    double panjangPersegiPanjang = scanner.nextDouble();
                    System.out.print("Masukkan lebar persegi panjang: ");
                    double lebarPersegiPanjang = scanner.nextDouble();

                    Segi segi = new Segi("Persegi Panjang", panjangPersegiPanjang, lebarPersegiPanjang, 4, 4);
                    System.out.println("Luas segi: " + segi.hitungLuas());
                    System.out.println("Keliling segi: " + segi.hitungKeliling());
                } else {
                    System.out.print("Masukkan sisi segi: ");
                    double sisiSegi = scanner.nextDouble();
                    System.out.print("Masukkan jumlah sisi segi: ");
                    double jumlahSisiSegi = scanner.nextDouble();

                    Segi segi = new Segi("Segi", 0,0, sisiSegi, jumlahSisiSegi);
                    System.out.println("Keliling segi: " + (jumlahSisiSegi != 4 ? segi.hitungKeliling(sisiSegi, jumlahSisiSegi) : segi.hitungKeliling()));

                }
                break;

            case 5: // Tabung
                System.out.print("Masukkan diameter tabung: ");
                double diameterTabung = scanner.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tinggiTabung = scanner.nextDouble();

                Tabung tabung = new Tabung("Tabung", diameterTabung, tinggiTabung);
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
                System.out.println("Luas trapesium: " + trapesium.hitungLuas());
                System.out.println("Keliling trapesium: " + trapesium.hitungKeliling());
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
        scanner.close();
    }
}
