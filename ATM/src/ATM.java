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

        boolean valid = false;
        int index = -1;
        for (int i = 0; i < data_atm.length; i++){
            if (data_atm[i][0] == nomorKartu){
                valid = true;
                index = i;
                break;
            }
        }

        if (valid){
            System.out.println("Masukkan PIN Anda: ");
            int pin = scanner.nextInt();
            if (data_atm[index][1] == pin){
                System.out.println("Jumlah uang yang ditarik :");
                int tarikUang = scanner.nextInt();

                if tarikUang > 
            } else{
                System.out.println("PIN Anda tidak valid!");
            }
        } else {
            System.out.println("Nomor Kartu yang diinputkan tidak valid!");
        } 

        scanner.close();
    }
}
        