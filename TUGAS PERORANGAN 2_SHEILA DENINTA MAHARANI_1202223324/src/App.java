import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("===Selamat Datang di Program Kalkulasi Nilai PBO===");

        while (true) { // program akan looping input data sampai user ingin exit
            System.out.print("\nInputkan Nama (atau ketik 'exit' untuk keluar): ");
            String nama = input.nextLine();

            if (nama.equalsIgnoreCase("exit")) {
                break; 
            }

            System.out.print("Inputkan NIM: ");
            int nim = input.nextInt();
            
            System.out.print("Inputkan Nilai Tubes: ");
            double nilaiTubes = input.nextDouble();
            
            System.out.print("Inputkan Nilai Quiz: ");
            double nilaiQuiz = input.nextDouble();
            
            System.out.print("Inputkan Nilai Tugas: ");
            double nilaiTugas = input.nextDouble();
            
            System.out.print("Inputkan Nilai UTS: ");
            double nilaiUTS = input.nextDouble();
            
            System.out.print("Inputkan Nilai UAS: ");
            double nilaiUAS = input.nextDouble();

            double nilaiAkhir = (nilaiTubes + nilaiQuiz + nilaiTugas + nilaiUTS + nilaiUAS) / 5.0;

            System.out.println("\nNama: " + nama);
            System.out.println("NIM: " + nim);
            System.out.println("Nilai Matkul PBO: " + nilaiAkhir);

            input.nextLine();
        }
    }
}
