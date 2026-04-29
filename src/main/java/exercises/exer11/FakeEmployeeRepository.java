package exercises.exer11;

public class FakeEmployeeRepository implements Repository<String, Employee> {
    private final Employee[] employees = new Employee[10];
    private int index = 0;

    @Override
    public void register(Employee e) {
        if (index < 10) {
            employees[index] = e;
            index++;
        }
    }

    @Override
    public Employee findById(String id) {
        for (Employee current : employees) {
            if (current.getId().equals(id)) {
                return current;
            }
        }
        return null;
    }
}
