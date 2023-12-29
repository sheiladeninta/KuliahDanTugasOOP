public class Company {
    private String name;
    private String description;
    private String contact;
    private String[] jobOpenings;

    public Company(String name, String description, String contact, String[] jobOpenings) {
        this.name = name;
        this.description = description;
        this.contact = contact;
        this.jobOpenings = jobOpenings;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    public String[] getJobOpenings() {
        return jobOpenings;
    }
}
