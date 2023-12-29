public class JobApplication {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JobApplication(JobListing selectedJob, JobSeeker applicant, String cvLink, String applicationReason) {
    }

    public JobSeeker getApplicant() {
        return null;
    }

    public JobListing getSelectedJob() {
        return null;
    }

}
