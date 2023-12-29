public class PartTimeJob extends Job {
    private int workingHours;

    public PartTimeJob(String title, double salary, int workingHours) {
        super(title, salary);
        this.workingHours = workingHours;
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Part-Time Job: " + title);
        System.out.println("Salary: $" + salary);
        System.out.println("Working Hours: " + workingHours + " hours per week");
    }
}
