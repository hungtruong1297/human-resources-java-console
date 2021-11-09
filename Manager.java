public class Manager extends Staff implements ICalculator{
    String jobTitle;

    public Manager(int id, String name, Date dob, double salaryFactor, Date startDate, String department, int daysOff, String jobTitle) {
        super(id, name, dob, salaryFactor, startDate, department, daysOff);
        this.jobTitle = jobTitle;
    }

    public Manager(int id, String name, String department, String jobTitle) {
        super(id,name,Date.create(1900,1,1),1.0,Date.create(2020,1,1),department,0);
        this.jobTitle = jobTitle;
    }

    public int getResponsibleSalary() {
        if (getJobTitle().equals("Business Leader"))
                return 8_000_000;
        if (getJobTitle().equals("Project Leader"))
            return 5_000_000;
        if (getJobTitle().equals("Technical Leader"))
            return 6_000_000;
        else return -1;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void displayInformation() {
        System.out.println(getId() + "\t" + getName() + "\t" + getDepartment() + "\t" + getJobTitle());
    }

    public static Manager create(int id, String name, String department, String jobTitle) {
        return new Manager(id, name, department, jobTitle);
    }
    //manager = salaryFactor*5tr + responsibleSalary
    @Override
    public int calculateSalary() {
        return (int)getSalaryFactor()*5_000_000 + getResponsibleSalary();
    }

}
