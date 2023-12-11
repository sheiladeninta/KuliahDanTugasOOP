import java.util.Scanner;

public class CobaTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ketikkan angka: ");
        String inputan = scanner.next();

        try {
            int hasil = Integer.parseInt(inputan);
            System.out.println("Parsed number: " + hasil);
        } catch (Exception e) {
            System.out.println("Error");
        }

        scanner.close();
    }
}
