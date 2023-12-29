public class JobSeeker {
    private String name;
    private String skills;
    private String lastEdu;

    public JobSeeker(String name, String skills, String lastEdu) {
        this.name = name;
        this.skills = skills;
        this.lastEdu = lastEdu;   
    }

    public String getName() {
        return name;
    }

    public String getSkills() {
        return skills;
    }

    public String getLastEdu() {
        return lastEdu;
    }

    public void displayJobSeekerDetails() {
        System.out.println("Job Seeker: " + name);
        System.out.println("Skills: " + skills);
        System.out.println("Last Education: " + lastEdu);
    }
}
