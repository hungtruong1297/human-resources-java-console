import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Staff implements ICalculator{
    private int id;
    private String name;
    private Date dob;
    private double salaryFactor;
    private Date startDate;
    private String department;
    private int daysOff;

    public Staff(int id, String name, Date dob, double salaryFactor, Date startDate, String department, int daysOff) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.salaryFactor = salaryFactor;
        this.startDate = startDate;
        this.department = department;
        this.daysOff = daysOff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getSalaryFactor() {
        return salaryFactor;
    }

    public void setSalaryFactor(double salaryFactor) {
        this.salaryFactor = salaryFactor;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    public abstract void displayInformation();

    public void displayDepartment() {
        System.out.println(getDepartment());
    }

    public abstract int calculateSalary();

    public int getSalary() {
        return calculateSalary();
    }

    public void displaySalary() {
        System.out.println(getId() + "\t" + getName() + "\t" + getDepartment() + "\t" + calculateSalary());
    }

}