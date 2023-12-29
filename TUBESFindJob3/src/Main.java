import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static RegisteredUser currentUser;
    private static ArrayList<Job> jobList = new ArrayList<>();
    private static ArrayList<Company> companyList = new ArrayList<>();
    private static ArrayList<ApplyJob> applications = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();

        Scanner scanner = new Scanner(System.in);
        int menu;

        do {
            displayMainMenu();
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    registerUser(scanner);
                    break;
                case 3:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
            }
        } while (menu != 3);

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("=== Aplikasi Pencari Kerja ===");
        System.out.println("1. Login");
        System.out.println("2. Daftar Diri");
        System.out.println("3. Keluar");
        System.out.print("\nPilih menu (1/2/3): ");
    }

    private static void login(Scanner scanner) {
        System.out.print("Masukkan nama pengguna: ");
        String username = scanner.next();
        System.out.print("Masukkan kata sandi: ");
        String password = scanner.next();

        // Validasi login menggunakan RegisteredUser
        RegisteredUser user = RegisteredUser.loginUser(username, password);

        if (user != null) {
            currentUser = user;
            displayJobMenu(scanner);
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Masukkan nama lengkap: ");
        scanner.nextLine();  // Menambahkan ini untuk mengkonsumsi newline character
        String fullName = scanner.nextLine();
        System.out.print("Masukkan pendidikan terakhir: ");
        String education = scanner.nextLine();
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Buatlah username: ");
        String username = scanner.nextLine();
        System.out.print("Buatlah password: ");
        String password = scanner.nextLine();

        // Registrasi user dengan informasi tambahan
        RegisteredUser.registerUser(username, password, fullName, education, email);
    }

    private static void displayJobMenu(Scanner scanner) {
        int menu;

        do {
            System.out.println("=== Aplikasi Pencari Kerja ===");
            System.out.println("1. Cari Lowongan dan Tampilkan Kode Loker");
            System.out.println("2. Daftar Perusahaan dan Kode Perusahaan");
            System.out.println("3. Tampilkan Semua Lowongan");
            System.out.println("4. Apply Pekerjaan");
            System.out.println("5. Keluar");
            System.out.print("\nPilih menu (1/2/3/4/5): ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    searchJobs(scanner);
                    break;
                case 2:
                    displayCompanies();
                    break;
                case 3:
                    displayAllJobs();
                    break;
                case 4:
                    applyJob(scanner);
                    break;
                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
            }
        } while (menu != 5);
    }

    private static void searchJobs(Scanner scanner) {
        System.out.print("Masukkan kata kunci pencarian: ");
        String keyword = scanner.next();

        // Implementasi pencarian pekerjaan berdasarkan kata kunci (diimplementasikan sesuai kebutuhan)
        // Anda dapat menggunakan loop untuk menelusuri daftar pekerjaan dan mencocokkan kata kunci.
        // Contoh sederhana: Menampilkan hasil dummy
        System.out.println("\nHasil Pencarian:");
        for (Job job : jobList) {
            if (job.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Judul: " + job.getTitle());
                System.out.println("Perusahaan: " + job.getCompany());
                System.out.println("Kualifikasi: " + job.getQualifications());
                System.out.println("Kode Loker: " + job.getJobCode());
                System.out.println("------------------------------");
            }
        }
        System.out.println();
    }

    private static void displayCompanies() {
        System.out.println("\nDaftar Perusahaan dan Kode Perusahaan:");
        for (Company company : companyList) {
            System.out.println("Nama Perusahaan: " + company.getName());
            System.out.println("Kode Perusahaan: " + company.getDescription());
            System.out.println("-----------------------------");
        }
        System.out.println();
    }

    private static void displayAllJobs() {
        System.out.println("\nTampilkan Semua Lowongan:");
        for (Job job : jobList) {
            System.out.println("Judul: " + job.getTitle());
            System.out.println("Perusahaan: " + job.getCompany());
            System.out.println("Kualifikasi: " + job.getQualifications());
            System.out.println("Kode Loker: " + job.getJobCode());
            System.out.println("-----------------------------");
        }
        System.out.println();
    }

    private static void applyJob(Scanner scanner) {
        System.out.print("Masukkan kode loker yang ingin dilamar: ");
        String jobCode = scanner.next();
        System.out.print("Masukkan link CV: ");
        String cvLink = scanner.next();
        scanner.nextLine(); // Consumes the newline character
        System.out.print("Berikan alasan mengapa Anda tertarik dengan lowongan ini: ");
        String reason = scanner.nextLine();

        // Implementasi pengajuan lamaran pekerjaan (diimplementasikan sesuai kebutuhan)
        // Anda dapat menambahkan validasi dan menyimpan lamaran ke daftar lamaran.
        // Contoh sederhana: Menyimpan lamaran dummy
        applications.add(new ApplyJob(jobCode, cvLink, reason));

        System.out.println("\nLamaran Anda untuk " + jobCode + " telah diajukan!\n");
    }

    private static void initializeData() {
        // Inisialisasi data dummy
        jobList.add(new Job("Software Engineer", "ABC Tech", "Pengalaman minimal 2 tahun dalam pengembangan perangkat lunak.", "SE123"));
        jobList.add(new Job("Data Scientist", "XYZ Analytics", "Latar belakang dalam analisis data dan pengalaman menggunakan alat analisis data.", "DS456"));

        String[] openings = {"Software Engineer", "Data Analyst"};
        companyList.add(new Company("ABC Solutions", "Perusahaan IT terkemuka yang fokus pada pengembangan solusi perangkat lunak inovatif.", "info@abcsolutions.com", openings));
    }
}
