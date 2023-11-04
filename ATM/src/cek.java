import java.util.Scanner;

public class cek {
    public static void main(String[] args) {
        int[][] data_atm = {
            // format data_atm: {nomor kartu, pin, saldo}
            {123456, 101010, 10000000},
            {135790, 202020, 5000000},
            {121314, 303030, 7000000},
            {143215, 404040, 2000000}
        };
        int jumlah_uang_di_atm = 3000000;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nomor kartu: ");
        int nomorKartu = scanner.nextInt();

        int pinIndex = -1;
        for (int i = 0; i < data_atm.length; i++) {
            if (data_atm[i][0] == nomorKartu) {
                pinIndex = i;
                break;
            }
        }

        if (pinIndex == -1) {
            System.out.println("Nomor kartu tidak valid");
            return;
        }

        System.out.print("Masukkan PIN: ");
        int pin = scanner.nextInt();

        if (data_atm[pinIndex][1] != pin) {
            System.out.println("PIN anda tidak valid");
            return;
        }

        System.out.print("Masukkan jumlah uang yang ingin ditarik: ");
        int jumlahTarik = scanner.nextInt();

        if (jumlahTarik > jumlah_uang_di_atm) {
            System.out.println("Jumlah uang di ATM tidak mencukupi");
            return;
        }

        if (jumlahTarik > data_atm[pinIndex][2]) {
            System.out.println("Saldo anda tidak mencukupi");
            return;
        }

        data_atm[pinIndex][2] -= jumlahTarik;
        jumlah_uang_di_atm -= jumlahTarik;

        System.out.println("ATM mengeluarkan uang Rp. " + jumlahTarik);
        System.out.println("Sisa saldo anda: Rp. " + data_atm[pinIndex][2]);
    }
}
