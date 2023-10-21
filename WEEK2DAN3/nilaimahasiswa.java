import java.util.Scanner;

public class nilaimahasiswa {
    public static void main(String[] args){
        // membuat objek input untuk user 
        Scanner input = new Scanner(System.in);
        // meminta memasukkan nama dan NIM
        System.out.print("Masukkan Nama :");
        String nama= input.nextLine();

        System.out.print("Masukkan NIM: ");
        Integer nim = input.nextInt();

        // meminta memasukkan nilai - nilai 
        System.out.print("Masukkan Nilai Tubes: ");
        double nialiTubes = input.nextDouble();

        System.out.print("Masukkan Nilai Quiz: ");
        double nilaiQuiz  = input.nextDouble();

        System.out.print("Masukkan Nilai Tugas: ");
        double nilaiTugas = input.nextDouble();

        System.out.print("Masukkan Nilai UTS: ");
        double nilaiUTS = input.nextDouble();

        System.out.print("Masukkan Nilai UAS: ");
        double nilaiUAS = input.nextDouble();

        // menghitung nilai akhir
        double nilaiAkhir = (0.30 * nialiTubes)+(0.10 * nilaiQuiz)+(0.10 * nilaiTugas)+(0.25 * nilaiUTS)+(0.25 * nilaiUAS);
        
        // menampilkan nama, nim dan nilai akhir
        System.out.print("\nNama : " + nama);
        System.out.print("NIM : " + nim);
        System.out.print("Nilai  Matakuliah Pemograman Berorientasi Objek :" + nilaiAkhir);

        // menutup scanner
        input.close();
    }   
}
