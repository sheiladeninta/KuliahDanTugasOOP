public class JobSeeker extends User{
    private static final long serialVersionUID = 1L;

    private String fullName;
    private String education;
    private String email;

    public JobSeeker(String username, String password, String fullName, String education, String email) {
        super(username, password);
        this.fullName = fullName;
        this.education = education;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEducation() {
        return education;
    }

    public String getEmail() {
        return email;
    }
}
