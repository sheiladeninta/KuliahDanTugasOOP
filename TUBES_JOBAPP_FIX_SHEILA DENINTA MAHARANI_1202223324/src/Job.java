public abstract class Job {
    protected String title;
    public double getSalary() {
        return salary;
    }

    protected double salary;

    public Job(String title, double salary) {
        this.title = title;
        this.salary = salary;
    }

    public abstract void displayJobDetails();
}
