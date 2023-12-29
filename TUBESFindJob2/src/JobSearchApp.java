import java.util.ArrayList;
import java.util.Scanner;

public class JobSearchApp {
    private Database database;
    private Authenticator authenticator;

    public JobSearchApp() {
        this.database = new Database();
        this.authenticator = new Authenticator();
    }

    public static void main(String[] args) {
        JobSearchApp app = new JobSearchApp();
        app.run();
    }

    private void saveData() {
        database.saveDataToDatabaseFile("job_seekers.txt", database.getAllJobSeekers());
        database.saveDataToDatabaseFile("partnership_requests.txt", database.getAllPartnershipRequests());
        database.saveDataToDatabaseFile("job_listings.txt", database.getAllJobListings());
        database.saveDataToDatabaseFile("job_applications.txt", database.getJobApplication());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Aplikasi Pencari Kerja ===");
            System.out.println("1. Login");
            System.out.println("2. Daftar Diri");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1/2/3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    loginJobSeeker(scanner);
                    break;
                case 2:
                    registerJobSeeker(scanner);
                    break;
                case 3:
                    saveData();
                    System.out.println("Terima kasih! Program selesai.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            if (authenticator.isAuthenticated()) {
                displayMenuAfterLogin(scanner);
            }
        }
    }

    private void loginJobSeeker(Scanner scanner) {
        System.out.print("Masukkan nama pengguna: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan kata sandi: ");
        String password = scanner.nextLine();

        if (Authenticator.login(username, password, database.getAllJobSeekers())) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal. Periksa nama pengguna dan kata sandi.");
        }
    }

    private void registerJobSeeker(Scanner scanner) {
        System.out.println("=== Pendaftaran Pencari Kerja ===");
        System.out.print("Masukkan nama lengkap: ");
        String fullName = scanner.nextLine();
        System.out.print("Masukkan pendidikan terakhir: ");
        String education = scanner.nextLine();
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Buatlah username: ");
        String username = scanner.nextLine();
        System.out.print("Buatlah password: ");
        String password = scanner.nextLine();

        JobSeeker jobSeeker = new JobSeeker(username, password, fullName, education, email);
        database.addJobSeeker(jobSeeker);
    }

    private void displayMenuAfterLogin(Scanner scanner) {
        while (authenticator.isAuthenticated()) {
            System.out.println("=== Menu Find Job ===");
            System.out.println("1. Cari Lowongan dan Tampilkan Kode Loker");
            System.out.println("2. Tampilkan Semua Lowongan");
            System.out.println("3. Apply Pekerjaan");
            System.out.println("4. Partnership");
            System.out.println("5. Konfirmasi Partnership (tambah loker by admin)");
            System.out.println("6. Keluar");
    
            System.out.print("Pilih menu (1-6): ");
            int loggedInChoice = scanner.nextInt();
    
            switch (loggedInChoice) {
                case 1:
                    searchAndDisplayJobListings(scanner);
                    break;
                case 2:
                    displayAllJobListings();
                    break;
                case 3:
                    applyForJob(scanner);
                    break;
                case 4:
                    displayPartnershipMenu(scanner);
                    break;
                case 5:
                    confirmPartnershipByAdmin(scanner);
                    break;
                case 6:
                    Authenticator.logout();
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
    
    private void searchAndDisplayJobListings(Scanner scanner) {
        System.out.print("Masukkan kata kunci pencarian: ");
        String keyword = scanner.nextLine();
        ArrayList<JobListing> searchResults = database.searchJobListings(keyword);
    
        System.out.println("Hasil Pencarian:");
        displayJobListings(searchResults);
    }
    
    private void displayAllJobListings() {
        System.out.println("=== Semua Lowongan Pekerjaan ===");
        ArrayList<JobListing> jobListings = database.getAllJobListings();
        displayJobListings(jobListings);
    }
    
    private void displayJobListings(ArrayList<JobListing> jobListings) {
        for (JobListing jobListing : jobListings) {
            System.out.println("Judul: " + jobListing.getTitle());
            System.out.println("Perusahaan: " + jobListing.getCompany());
            System.out.println("Kualifikasi: " + jobListing.getQualifications());
            System.out.println("Kode Lowongan: " + jobListing.getJobCode());
            System.out.println("------------------------");
        }
    }
    
    private void applyForJob(Scanner scanner) {
        System.out.print("Masukkan kode loker yang ingin dilamar: ");
        String jobCode = scanner.nextLine();
        JobListing selectedJob = database.getJobListingByCode(jobCode);
    
        if (selectedJob != null) {
            System.out.print("Masukkan link CV: ");
            String cvLink = scanner.nextLine();
            System.out.print("Berikan alasan mengapa Anda tertarik dengan lowongan ini: ");
            String applicationReason = scanner.nextLine();
    
            JobSeeker applicant = Authenticator.getLoggedInJobSeeker();
            JobApplication jobApplication = new JobApplication(selectedJob, applicant, cvLink, applicationReason);
            database.submitJobApplication(jobApplication);
    
            System.out.println("Lamaran Anda untuk " + selectedJob.getTitle() + " telah diajukan!");
        } else {
            System.out.println("Kode loker tidak valid. Silakan coba lagi.");
        }
    }
    
    private void displayPartnershipMenu(Scanner scanner) {
        System.out.println("=== Menu Partnership ===");
        System.out.println("Instansi yang ingin bekerjasama, silahkan isi formulir di bawah ini:");

        System.out.print("Masukkan nama perusahaan: ");
        String companyName = scanner.nextLine();
        System.out.print("Masukkan deskripsi perusahaan: ");
        String companyDescription = scanner.nextLine();
        System.out.print("Masukkan kontak perusahaan: ");
        String companyContact = scanner.nextLine();
        System.out.print("Masukkan lowongan pekerjaan (pisahkan dengan koma jika lebih dari satu): ");
        String jobOpenings = scanner.nextLine();
        System.out.print("Masukkan kualifikasi umum: ");
        String generalQualifications = scanner.nextLine();
    
        PartnershipRequest partnershipRequest = new PartnershipRequest(companyName, companyDescription, companyContact, jobOpenings, generalQualifications);
        database.addPartnershipRequest(partnershipRequest);
    
        System.out.println("Permintaan kerjasama dari " + companyName + " telah diajukan!");
    }
    
    private void confirmPartnershipByAdmin(Scanner scanner) {
        System.out.println("=== Konfirmasi Partnership ===");

        // Menampilkan data permintaan partnership
        System.out.println("## Data Permintaan ##");
        ArrayList<PartnershipRequest> partnershipRequests = database.getAllPartnershipRequests();
        for (PartnershipRequest request : partnershipRequests) {
            System.out.println("Nama perusahaan: " + request.getCompanyName());
            System.out.println("Deskripsi perusahaan: " + request.getCompanyDescription());
            System.out.println("Kontak perusahaan: " + request.getCompanyContact());
            System.out.println("Lowongan pekerjaan: " + request.getJobVacancies());
            System.out.println("Kualifikasi umum: " + request.getGeneralQualifications());
            System.out.println();
        }

        // Admin menginputkan data loker
        boolean continueAddingJob = true;
        while (continueAddingJob) {
            System.out.println("### Input Data Lowongan ###");
            System.out.print("Judul: ");
            String title = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Perusahaan: ");
            String company = scanner.nextLine();
            System.out.print("Kualifikasi: ");
            String qualifications = scanner.nextLine();
            System.out.print("Kode Loker: ");
            String jobCode = scanner.nextLine();

            // Membuat objek JobListing dari input admin
            JobListing newJobListing = new JobListing(title, company, qualifications, jobCode);

            // Menambahkan lowongan ke database
            database.addJobListing(newJobListing);

            System.out.print("Apakah ingin lanjut menambahkan loker? (Y/N): ");
            String continueInput = scanner.nextLine();
            continueAddingJob = continueInput.equalsIgnoreCase("Y");
        }

        displayMenuAfterLogin(scanner);
    }
}
