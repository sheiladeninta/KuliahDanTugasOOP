import java.util.ArrayList;
import java.util.Scanner;

import model.Mahasiswa;
import model.Prodi;
import repository.Database;

public class KampusApp {
    public static void main(String[] arg) {
        KampusApp kampusApp = new KampusApp();
        kampusApp.showMenu();
    }

    private Scanner scanner;
    private Database db;

    public KampusApp() {
        scanner = new Scanner(System.in);
        db = new Database();
    }

    public void showMenu() {
        System.out.println("---------------------------------");
        System.out.println("Selamat Datang di Aplikasi Kampus");
        System.out.println("Pilihan Menu:");
        System.out.println("1 -> Tambah Data Prodi");
        System.out.println("2 -> Ubah Data Prodi");
        System.out.println("3 -> Hapus Data Prodi");
        System.out.println("4 -> Tambah Data Mahasiswa");
        System.out.println("5 -> Ubah Data Mahasiswa");
        System.out.println("6 -> Hapus Data Mahasiswa");
        System.out.println("7 -> Cari Data Mahasiswa");
        System.out.println("8 -> Tampilkan Semua Data Mahasiswa");
        System.out.println("9 -> Tampilkan Semua Data Prodi");
        System.out.println("0 -> Keluar Aplikasi");
        System.out.print("Silahkan masukan menu yang dipilih: ");
        int menuYangDipilih = scanner.nextInt();
        scanner.nextLine();
        switch(menuYangDipilih) {
            case 1:
            AddProdi();
            break;
            case 2:
            UbahProdi();
            break;
            case 3:
            HapusProdi();
            case 4:
            menuTambah();
            break;
            case 5:
            menuUbah();
            break;
            case 6:
            menuHapus();
            break;
            case 7:
            menuCari();
            break;
            case 8:
            SemuaDataMahasiswa();
            break;
            case 9:
            SemuaDataProdi();
            break;
            default: {
                System.out.print("* Terimakasih sudah menggunakan Aplikasi Kampus *");
                System.exit(0);
            }
            break;
        }
        scanner.close();
    }

    public void AddProdi() {
        System.out.println("----- Menu Tambah Prodi -----");
        System.out.print("Masukkan ID Prodi: ");
        String IDProdi = scanner.nextLine();
        System.out.print("Masukkan Nama Prodi: ");
        String namaProdi = scanner.nextLine();
        Prodi prodi = new Prodi(IDProdi, namaProdi);
        db.prodiTbl.create(prodi);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void UbahProdi() {
        System.out.println("----- Menu Ubah Data Prodi -----");
        System.out.print("Masukan ID Prodi Sebelumnya: ");
        String IDProdiLama = scanner.nextLine();
        System.out.print("Masukkan ID Prodi: ");
        String IDProdiBaru = scanner.nextLine();
        System.out.print("Masukan Nama Prodi: ");
        String namaProdi = scanner.nextLine();
        Prodi prodi = new Prodi(IDProdiBaru, namaProdi);
        db.prodiTbl.update(IDProdiLama, prodi);
        System.out.println("Prodi sudah berhasil diubah!");
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void HapusProdi() {
        System.out.println("----- Menu Hapus Data Prodi -----");
        System.out.print("Masukan Id Prodi: ");
        String IDProdi = scanner.nextLine();
        db.prodiTbl.delete(IDProdi);
        System.out.println("Prodi dengan id " + IDProdi + " berhasil dihapus");
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();

    }

    public void menuTambah() {
        System.out.println("----- Menu Tambah Mahasiswa -----");
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID Prodi: ");
        String IDProdi = scanner.nextLine();
        Prodi prodi = db.prodiTbl.getProdiById(IDProdi);

        if (prodi == null) {
            System.out.println("* ID Prodi tidak ditemukan *");
            System.out.println("Tekan Enter untuk melanjutkan...");
            scanner.nextLine();
            showMenu();
        } else {
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, IDProdi);
            db.mahasiswaTbl.create(mahasiswa);
            System.out.println("* Data Mahasiswa berhasil ditambahkan! *");

        }
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuUbah() {
        System.out.println("----- Menu Ubah Data Mahasiswa -----");
        System.out.print("Masukan NIM Sebelumnya: ");
        String nimLama = scanner.nextLine();
        System.out.print("Masukan NIM: ");
        String nimBaru = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Id Prodi: ");
        String IDProdi = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(nimBaru, nama, IDProdi);
        db.mahasiswaTbl.update(nimLama, mahasiswa);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuCari(){
        System.out.println("----- Menu Cari Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        Mahasiswa mahasiswa = db.mahasiswaTbl.getMahasiswaByNim(nim);
        Prodi prodi = db.prodiTbl.getProdiById(mahasiswa.getIDProdi());
        if (mahasiswa == null) {
            System.out.println("* NIM tidak ditemukan *");
        } else if (prodi.getIDProdi() == null) {
            System.out.println("* ID Prodi tidak ditemukan *");
        } else {
            System.out.println("* NIM: " + mahasiswa.getNim() + " *");
            System.out.println("* Nama: " + mahasiswa.getNama() + " *");
            System.out.println("* Prodi: " + prodi.getNamaProdi() + " *");
        }
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuHapus() {
        System.out.println("----- Menu Hapus Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        db.mahasiswaTbl.delete(nim);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();

    }

    public void SemuaDataProdi() {
        System.out.println("----- Menampilkan Semua Data Prodi -----");
        ArrayList<Prodi> semuaProdi = db.tables.dataProdi;
        if (semuaProdi.isEmpty()) {
            System.out.println("Tidak ada data prodi yang tersimpan.");
        } else {
            System.out.println("Daftar Prodi:");
            for (Prodi prodi : semuaProdi) {
                System.out.println("ID Prodi: " + prodi.getIDProdi());
                System.out.println("Nama Prodi: " + prodi.getNamaProdi());
                System.out.println("--------------------------------------------");
            }
        }
        showMenu();
    }
    
    public void SemuaDataMahasiswa() {
        System.out.println("----- Menampilkan Semua Data Mahasiswa -----");
        ArrayList<Mahasiswa> semuaMahasiswa = db.read();
        if (semuaMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa yang tersimpan.");
        } else {
            System.out.println("Daftar Mahasiswa:");
            for (Mahasiswa mahasiswa : semuaMahasiswa) {
                System.out.println("NIM: " + mahasiswa.getNim());
                System.out.println("Nama: " + mahasiswa.getNama());
                System.out.println("Prodi: " + db.prodiTbl.getProdiById(mahasiswa.getIDProdi()).getNamaProdi());
                System.out.println("--------------------------------------------");
            }
        }
        showMenu();
    }
    
}