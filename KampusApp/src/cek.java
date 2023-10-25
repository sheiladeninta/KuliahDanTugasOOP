import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class cek {
    public static void main(String[] args) {
        cek cek = new cek();
        cek.showMenu();
    }

    private Scanner scanner;
    private Database database;

    public cek() {
        scanner = new Scanner(System.in);
        database = new Database();
    }

    public void showMenu() {
        int menuYangDipilih;
    
        do { // Update 6 : do-while u/ perulangan agar user bisa memilih menu lain setelah milih menu yg satunya, jd jika ingin keluar user perlu pakai menu keluar (0)
            System.out.println("---- Selamat Datang di Aplikasi Kampus ----");
            System.out.println("Pilihan Menu:");
            System.out.println("1 -> Tambah Data Mahasiswa");
            System.out.println("2 -> Ubah Data Mahasiswa");
            System.out.println("3 -> Hapus Data Mahasiswa");
            System.out.println("4 -> Cari Data Mahasiswa");
            System.out.println("5 -> Tampilkan Semua Data Mahasiswa");
            System.out.println("0 -> Keluar Aplikasi");
            System.out.print("Silahkan masukkan menu yang dipilih: ");
    
            menuYangDipilih = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline
    
            switch (menuYangDipilih) {
                case 1:
                    menuTambah();
                    break;
                case 2:
                    menuUbah();
                    break;
                case 3:
                    menuHapus();
                    break;
                case 4:
                    menuCari();
                    break;
                case 5:
                    menuTampilkanSemua();
                    break;
                case 0:
                    System.out.println("* Terima kasih sudah menggunakan Aplikasi Kampus *");
                    break;
                default:
                    System.out.println("Menu yang Anda pilih tidak valid.");
                    break;
            }
        } while (menuYangDipilih != 0);
    }    

    public void menuTambah() {
        System.out.println("-- Menu Tambah Mahasiswa --");
    
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
    
        // Update 1 : cek apakah NIM sudah ada dalam database -> menggunakan konsep database primary key
        if (database.read(nim) != null) {
            System.out.println("* NIM " + nim + " sudah ada dalam database. Data tidak dapat ditambahkan *");
        } else {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
    
            Long noHP = null;
            boolean validNoHP = false;

            while (!validNoHP) { // Update 3 : untuk mendeteksi input selain angka
                try {
                    System.out.print("Masukkan No. HP: ");
                    noHP = scanner.nextLong();
                    validNoHP = true;
                } catch (InputMismatchException e) {
                    System.out.println("* Nomor HP harus berupa angka *");
                    scanner.nextLine(); // Membersihkan newline
                }
            }
    
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, noHP);
    
            database.create(mahasiswa);
    
            System.out.println("Data berhasil ditambahkan.");
        }
    }    

    public void menuUbah() {
        System.out.println("-- Menu Ubah Data Mahasiswa --");
    
        System.out.print("Masukkan NIM Sebelumnya: ");
        String nimLama = scanner.nextLine();
    
        Mahasiswa mahasiswaLama = database.read(nimLama);
    
        if (mahasiswaLama == null) { // Update 2 : jika ada typo trs tidak ada di database maka ada warning data belum ditemukan
            System.out.println("Data yang dimasukkan tidak ditemukan!");
        } else {
            System.out.print("Masukkan NIM Baru: ");
            String nimBaru = scanner.nextLine();
    
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();

            Long noHpbaru = null;
            boolean validNoHP = false;

            while (!validNoHP){
                try {
                    System.out.print("Masukkan no hp:");
                    noHpbaru = scanner.nextLong();
                    validNoHP = true;

                } catch (InputMismatchException e){
                    System.out.println("nomor hp harus angka")
                    scanner.nextLine();

                }
            }
    
            Mahasiswa mahasiswaBaru = new Mahasiswa(nimBaru, nama, noHPbaru);
    
            database.update(mahasiswaBaru, nimLama);
    
            System.out.println("Data berhasil diubah.");
        }
    }    

    public void menuCari() { // Update 4 : mencari data siswa berdasarkan kata kunci yg diinginkan user
        System.out.println("-- Menu Cari Data Mahasiswa --");
        System.out.print("Masukkan kata kunci: ");
        String keyword = scanner.nextLine().toLowerCase(); // Menggunakan toLowerCase() agar pencarian tidak bersifat case-sensitive
    
        ArrayList<Mahasiswa> hasilPencarian = new ArrayList<>();
    
        for (Mahasiswa mahasiswa : database.read()) {
            if (mahasiswa.getNim().toLowerCase().contains(keyword) ||
                mahasiswa.getNama().toLowerCase().contains(keyword)) {
                hasilPencarian.add(mahasiswa);
            } else {
                // Menambahkan kode untuk memeriksa nomor HP dengan kata kunci
                long noHP = mahasiswa.getNoHP();
                if (String.valueOf(noHP).contains(keyword)) {
                    hasilPencarian.add(mahasiswa);
                }
            }
        }
    
        if (hasilPencarian.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa yang cocok dengan kata kunci '" + keyword + "'.");
        } else {
            System.out.println("Hasil Pencarian:");
    
            for (Mahasiswa mahasiswa : hasilPencarian) {
                System.out.println("NIM: " + mahasiswa.getNim());
                System.out.println("Nama: " + mahasiswa.getNama());
                System.out.println("No. HP: " + mahasiswa.getNoHP());
                System.out.println("----------------------");
            }
        }
    }    

public void menuTampilkanSemua() { // Update 5 : tampilan semua data
    System.out.println("-- Menampilkan Semua Data Mahasiswa --");
    
    ArrayList<Mahasiswa> semuaMahasiswa = database.read();

    if (semuaMahasiswa.isEmpty()) {
        System.out.println("Tidak ada data mahasiswa yang tersimpan.");
    } else {
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa mahasiswa : semuaMahasiswa) {
            System.out.println("NIM: " + mahasiswa.getNim());
            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println("No. HP: " + mahasiswa.getNoHP());
            System.out.println("----------------------");
        }
    }
}

    public void menuHapus() {
        System.out.println("-- Menu Hapus Data Mahasiswa --");

        System.out.print("Masukkan NIM yang akan dihapus: ");
        String nim = scanner.nextLine();

        database.delete(nim);

        System.out.println("Data berhasil dihapus.");
    }
}