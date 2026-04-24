package exercises.exer11;

public class FakeEmployeeRepository implements Repository<Employee>{
    Employee[] employees = new Employee[10];
    private int index = 0;
    @Override
    public void register(Employee e) {
        if(index<10){
            employees[index] = e;
            index++;
        }
    }

    @Override
    public <T, R> T findById(R id) {
        for(Employee current: employees){
            if(current.getId().equals(id)){
                return (T)current;
            }
        }
        return null;
    }
}
