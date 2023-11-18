public class App {
    // overloading : ada banyak method tp beda2 input dan output
    public static int tambah(int a, int b) {
        int hasil = a + b;
        return hasil;
    }

    public static int tambah(int a, int b, int c) {
        int hasil = a + b + c;
        return hasil;
    }

    public static void main(String[] args) throws Exception {
        // Memanggil metode pertama
        int hasil1 = tambah(10, 11);
        System.out.println("Hasil pertama: " + hasil1);

        // Memanggil metode kedua
        int hasil2 = tambah(5, 7, 8);
        System.out.println("Hasil kedua: " + hasil2);
    }
}
