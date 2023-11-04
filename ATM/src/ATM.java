import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        int[][] data_atm = {
            // format data_atm: {nomor kartu, pin, saldo}
            {123456, 101010, 10000000},
            {135790, 202020, 5000000},
            {121314, 303030, 7000000},
            {143215, 404040, 2000000}
        };
        int jumlah_uang_di_atm = 3000000;

        System.out.println("Selamat Datang di ATM!");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nomor kartu: ");
        int nomorKartu = scanner.nextInt();
        System.out.println("Masukkan PIN: ");
        int pin = scanner.nextInt();

        int pinIndex = 1;
        for (int i = 0; i < data_atm.length; i++) {
            if (data_atm [i][0] == nomorKartu){
                pinIndex = i;
                break;
            }
        }
        if (pinIndex == -0) {
            System.out.println("Nomor kartu SALAH!");
            return;
        }
    }

}
        