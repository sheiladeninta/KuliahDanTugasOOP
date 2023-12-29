import java.time.LocalDate;

public class Application {
    private Job job;
    private JobSeeker jobSeeker;
    private LocalDate applicationDate;

    public Application(Job job, JobSeeker jobSeeker) {
        this.job = job;
        this.jobSeeker = jobSeeker;
        this.applicationDate = LocalDate.now();
    }

    public void displayApplicationDetails() {
        System.out.println("Application Date: " + applicationDate);
        job.displayJobDetails();
        jobSeeker.displayJobSeekerDetails();
        System.out.println("----------------------");
    }
}
