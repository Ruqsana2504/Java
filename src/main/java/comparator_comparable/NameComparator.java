package comparator_comparable;

import java.util.Comparator;

public class NameComparator implements Comparator<Employeee> {
    @Override
    public int compare(Employeee o1, Employeee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
