import java.util.Comparator;

public class NameSorter implements Comparator<Staff>
{
    @Override
    public int compare(Staff o1, Staff o2) {
        return o2.getName().compareToIgnoreCase(o1.getName());
    }
}