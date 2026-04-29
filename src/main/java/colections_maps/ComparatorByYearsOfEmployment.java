package colections_maps;

import java.util.Comparator;

public class ComparatorByYearsOfEmployment implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare((int) e1.getYearsOfService(), (int) e2.getYearsOfService());
    }
}