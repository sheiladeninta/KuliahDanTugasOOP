import java.io.Serializable;

public class JobListing implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String company;
    private String qualifications;
    private String jobCode;

    public JobListing(String title, String company, String qualifications, String jobCode) {
        this.title = title;
        this.company = company;
        this.qualifications = qualifications;
        this.jobCode = jobCode;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getJobCode() {
        return jobCode;
    }
}
