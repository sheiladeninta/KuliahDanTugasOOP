import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobApp {
    private static User loggedInUser = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loginPage(scanner);
        if (loggedInUser != null) {
            mainMenu(scanner);
        }
        scanner.close();
    }

    private static void loginPage(Scanner scanner) {
        System.out.println("==== Login Page ====");
        int attempts = 3;
        do {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();
            if (UserManager.authenticateUser(username, password)) {
                loggedInUser = new User(username, password);
                System.out.println("Login berhasil! Selamat datang, " + username + "!");
                break;
            } else {
                attempts--;
                System.out.println("Invalid username/password. Sisa attempts: " + attempts);
            }
        } while (attempts > 0);
        if (attempts == 0) {
            System.out.println("Too many failed attempts. Program selesai.");
            System.exit(0);
        }
    }

    private static void mainMenu(Scanner scanner) {
        List<Job> jobs = new ArrayList<>();
        List<JobSeeker> jobSeekers = new ArrayList<>();
        List<Application> applications = new ArrayList<>();
        int choice;
        do {
            System.out.println("==== Job Application Portal ====");
            System.out.println("1. Add Full-Time Job [Admin]");
            System.out.println("2. Add Part-Time Job [Admin]");
            System.out.println("3. Display All Jobs");
            System.out.println("4. Search Jobs by Salary");
            System.out.println("5. Add Job Seeker");
            System.out.println("6. Display All Job Seekers");
            System.out.println("7. Apply for Job");
            System.out.println("8. Display All Applications");
            System.out.println("9. Exit");
            System.out.print("Masukkan menu yang dipilih (1-9): ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addFullTimeJob(jobs, scanner);
                        break;
                    case 2:
                        addPartTimeJob(jobs, scanner);
                        break;
                    case 3:
                        displayAllJobs(jobs);
                        break;
                    case 4:
                        searchJobsBySalary(jobs, scanner);
                        break;
                    case 5:
                        addJobSeeker(jobSeekers, scanner);
                        break;
                    case 6:
                        displayAllJobSeekers(jobSeekers);
                        break;
                    case 7:
                        applyForJob(jobs, jobSeekers, applications, scanner);
                        break;
                    case 8:
                        displayAllApplications(applications);
                        break;
                    case 9:
                        System.out.println("Program selesai!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please Masukkan a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); 
                choice = 0; 
            }
            System.out.println(); 
        } while (choice != 9);
        scanner.close();
    }

    private static void addFullTimeJob(List<Job> jobs, Scanner scanner) {
        System.out.print("Masukkan Title Full-Time Job: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan Salary Full-Time Job: Rp ");
        double salary = scanner.nextDouble();
        System.out.print("Masukkan Jumlah Jam Kerja Full-Time Job per Minggu: ");
        int workingHours = scanner.nextInt();
        FullTimeJob fullTimeJob = new FullTimeJob(title, salary, workingHours);
        jobs.add(fullTimeJob);
        System.out.println("Data Full-Time Job berhasil ditambahkan!");
    }

    private static void addPartTimeJob(List<Job> jobs, Scanner scanner) {
        System.out.print("Masukkan Title Part-Time Job: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan Salary Part-Time Job: Rp ");
        double salary = scanner.nextDouble();
        System.out.print("Masukkan Jumlah Jam Kerja Part-Time Job per Minggu: ");
        int workingHours = scanner.nextInt();
        PartTimeJob partTimeJob = new PartTimeJob(title, salary, workingHours);
        jobs.add(partTimeJob);
        System.out.println("Data Part-Time Job berhasil ditambahkan!");
    }

    private static void displayAllJobs(List<Job> jobs) {
        if (jobs.isEmpty()) {
            System.out.println("Belum ada lowongan kerja yang tersedia.");
        } else {
            System.out.println("==== All Jobs ====");
            for (int i = 0; i < jobs.size(); i++) {
                System.out.println("Index : " + i);
                jobs.get(i).displayJobDetails();
                System.out.println("----------------------");
            }
        }
    }

    private static void searchJobsBySalary(List<Job> jobs, Scanner scanner) {
        System.out.print("Masukkan minimum salary yang dicari: Rp ");
        double minSalary = scanner.nextDouble();
        System.out.println("==== Jobs dengan Salary >= Rp" + minSalary + " ====");
        boolean found = false;
        for (Job job : jobs) {
            if (job.getSalary() >= minSalary) {
                job.displayJobDetails();
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Belum ada jobs dengan salary >= Rp" + minSalary);
        }
    }

    private static void addJobSeeker(List<JobSeeker> jobSeekers, Scanner scanner) {
        System.out.print("Masukkan Nama Job Seeker: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan Skills Job Seeker : ");
        String skills = scanner.nextLine();
        System.out.print("Masukkan Last Education Job Seeker : ");
        String lastEdu = scanner.nextLine();
        JobSeeker jobSeeker = new JobSeeker(name, skills, lastEdu);
        jobSeekers.add(jobSeeker);
        System.out.println("Job Seeker sukses ditambahkan!");
    }

    private static void displayAllJobSeekers(List<JobSeeker> jobSeekers) {
        if (jobSeekers.isEmpty()) {
            System.out.println("Belum ada job seekers yang terdaftar.");
        } else {
            System.out.println("==== All Job Seekers ====");
            for (int i = 0; i < jobSeekers.size(); i++) {
                System.out.println("Index : " + i);
                jobSeekers.get(i).displayJobSeekerDetails();
                System.out.println("----------------------");
            }
        }
    }

    private static void applyForJob(List<Job> jobs, List<JobSeeker> jobSeekers, List<Application> applications, Scanner scanner) {
        if (jobs.isEmpty() || jobSeekers.isEmpty()) {
            System.out.println("Sorry! Tidak bisa apply for job karena tidak ada data yang terdaftar.");
            return;
        }
        System.out.println("==== Apply for Job ====");
        displayAllJobs(jobs);
        System.out.print("Masukkan index job yang ingin diapply: ");
        int jobIndex = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("---- Available Job Seekers ----");
        displayAllJobSeekers(jobSeekers);
        System.out.print("Masukkan index job seeker yang ingin apply for job: ");
        int jobSeekerIndex = scanner.nextInt();
        scanner.nextLine(); 
        if (jobIndex >= 0 && jobIndex < jobs.size() && jobSeekerIndex >= 0 && jobSeekerIndex < jobSeekers.size()) {
            Job job = jobs.get(jobIndex);
            JobSeeker jobSeeker = jobSeekers.get(jobSeekerIndex);

            Application application = new Application(job, jobSeeker);
            applications.add(application);
            System.out.println("Job application telah disubmit!");
        } else {
            System.out.println("Invalid index. Application gagal!");
        }
    }

    private static void displayAllApplications(List<Application> applications) {
        if (applications.isEmpty()) {
            System.out.println("Tidak ada job application yang tersubmit.");
        } else {
            System.out.println("==== All Job Applications ====");
            for (Application application : applications) {
                application.displayApplicationDetails();
            }
        }
    }
}
