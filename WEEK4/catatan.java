// import java.util.Scanner;

import java.util.Scanner;

public class catatan {
    public static void main(String[] args) {
// if-else-----------------------------------
        int a = 3; int b = 10; int c = 2;

        if (a == 3 && (b == 4 || c == 2)) {
            System.out.println("Benar");
        } else {
            System.out.println("Salah");
        }
// switch------------------------------------
        switch(a){
            case 0:{
                break;
            }
            case 1:{
                break;
            }
            default:{
                break;
            }
        }
// for---------------------------------------
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print("*"); // untuk cetak ke kanan
            }
            System.out.println("*"); // untuk cetak ke bawah 

        }

// contoh for 2-----for di dalam for untuk 2 dimensi -> x dan y
        int input = 5;  
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < (i+1); j++) {
                System.out.print("* ");
            }
            System.out.println(); 
        }

// contoh for 3
        int input = 9;
        if (input % 2 == 0) {
            System.out.println("Input harus ganjil.");
            return;
        }
        int tengah = input / 2;
        for (int i = 0; i < input; i++) {
            int bintang = i < tengah ? i + 1 : input - i;
            for (int j = 0; j < bintang; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
// contoh for 4
        int input = 5;
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < (input-1); j++) {
                System.out.print("*");
            }
            char huruf = (char) ('A' + i);
            System.out.print(huruf);

            System.out.println();
        }

// contoh for 5
        int input = 5;
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < (input-1); j++) {
                System.out.print("*");
            }

            System.out.println(i + 1);
        }

// CEK AJAH
        System.out.println((int)'B');

// contoh lagi
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Angka :");
        Integer angka = input.nextInt();
        if (angka / 2 == 0){
            System.out.print("genap");
        } else{
                System.out.print("ganjil");
        }

// contoh lagi
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan umur :");
        Integer umur = input.nextInt();
        String kategori;
        switch (umur){
            case 0 - 13:
                kategori = "anak-anak";
                break;
            case 13-18:
                kategori = "remaja";
                break;
            case 19-59:
                kategori = "dewasa";
            case >= 60:
                kategori = "lansia";
        }
        System.out.println(kategori);

// contoh
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan umur: ");
        int umur = input.nextInt();

        if (umur <= 12) {
            System.out.println("Anak-anak");
        } else if (umur >= 13 && umur <= 18) {
            System.out.println("Remaja");
        } else if (umur > 19 && umur < 59) {
            System.out.println("Dewasa");
        } else if (umur >= 60) {
            System.out.println("Lansia");
        }

// contoh 
        int input = 5;  
        for (int i = input; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println(); 
        }
// contoh 
        int input = 5;  
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input-i; j++) {
                System.out.print("*");
            }
            System.out.println(); 
        }

// while - bedanya dengan for, for iterasinya sudah jelas
// do while
    }
}

