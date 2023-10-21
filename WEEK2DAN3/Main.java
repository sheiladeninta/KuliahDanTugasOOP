import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // inisiasi reader
        Scanner scanner = new Scanner(System.in);

        // inisiasi class kalkulator
        kalkulator kalkulatorSaya = new kalkulator();

        // label informasi
        System.out.print("Masukkan angka pertama: ");
        // input angka pertama
        double angka1 = scanner.nextDouble();

        System.out.print("Masukkan operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        System.out.print("Masukkan angka kedua: ");
        double angka2 = scanner.nextDouble();

        // hasil
        double hasil = kalkulatorSaya.hitung(angka1, angka2, operator);

        System.out.println("Hasil: " + hasil);
    }
}