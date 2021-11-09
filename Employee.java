public class Employee extends Staff implements ICalculator {
    private int extraHours;

    public Employee(int id, String name, Date dob, double salaryFactor, Date startDate, String department, int daysOff, int extraHours) {
        super(id, name, dob, salaryFactor, startDate, department, daysOff);
        this.extraHours = extraHours;
    }

    public Employee(int id, String name, String department) {
        super(id, name, Date.create(1900,1,1),1,Date.create(2020,1,1),department, 0);
        this.extraHours = 0;
    }


    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    public void displayInformation() {
        System.out.println(getId() + "\t" + getName() + "\t" + getDepartment());
    }



    public static Employee create(int id, String name, String department) {
        return new Employee(id,name,department);
    }

    public static Employee create(int id, String name, Date dob, double salaryFactor, Date startDate, String department, int daysOff, int extraHours) {
        return new Employee(id, name, dob, salaryFactor,startDate,department,daysOff,extraHours);
    }

    //employee = salaryFactor * 3tr + extraHours * 200k
    @Override
    public int calculateSalary() {
        return (int)this.getSalaryFactor() * 3_000_000 + this.extraHours*200_000;
    }
}
