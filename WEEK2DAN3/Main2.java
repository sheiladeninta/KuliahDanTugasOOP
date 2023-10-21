import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        kalkulator2 kalkulatorSaya = new kalkulator2();

        System.out.println("masukkan angka 1:");
        double angka1 = scanner.nextDouble();

        System.out.println("masukkan angka 2:");
        double angka2 = scanner.nextDouble();

        double hasil = kalkulatorSaya.tambah(angka1, angka2);
        System.out.println("hasil:" +hasil);
    }
}