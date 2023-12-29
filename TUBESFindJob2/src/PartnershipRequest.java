import java.io.Serializable;

public class PartnershipRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String companyName;
    private String companyDescription;
    private String companyContact;
    private String jobVacancies;
    private String generalQualifications;

    public PartnershipRequest(String companyName, String companyDescription, String companyContact,
                              String jobVacancies, String generalQualifications) {
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.companyContact = companyContact;
        this.jobVacancies = jobVacancies;
        this.generalQualifications = generalQualifications;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public String getJobVacancies() {
        return jobVacancies;
    }

    public String getGeneralQualifications() {
        return generalQualifications;
    }
}
