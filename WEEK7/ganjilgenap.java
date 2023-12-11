import java.util.Scanner;

public class ganjilgenap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan angka:");
        int angka = scanner.nextInt();
        if (angka % 2 == 0){
            System.out.println("Ini angka genap!");
        } else {
            System.out.println("Ini angka ganjil!");
        }
    }
}