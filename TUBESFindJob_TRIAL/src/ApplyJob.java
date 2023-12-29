public class ApplyJob {
    private String jobCode;
    private String cvLink;
    private String reason;

    public ApplyJob(String jobCode, String cvLink, String reason) {
        this.jobCode = jobCode;
        this.cvLink = cvLink;
        this.reason = reason;
    }

    public String getJobCode() {
        return jobCode;
    }

    public String getCvLink() {
        return cvLink;
    }

    public String getReason() {
        return reason;
    }
}
