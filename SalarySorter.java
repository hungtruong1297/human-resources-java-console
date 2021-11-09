import java.util.Comparator;

public class SalarySorter implements Comparator<Staff>
{
    @Override
    public int compare(Staff o1, Staff o2) {
        return o1.getSalary() - o2.getSalary();
    }
}