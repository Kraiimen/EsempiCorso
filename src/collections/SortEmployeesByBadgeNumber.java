package collections;

import java.util.Comparator;

public class SortEmployeesByBadgeNumber implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getBadgeNumber().compareTo(o2.getBadgeNumber());
    }
}
