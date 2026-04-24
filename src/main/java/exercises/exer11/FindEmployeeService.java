package exercises.exer11;

public class FindEmployeeService {
    private final Repository repository;

    public FindEmployeeService(Repository repository) {
        this.repository = repository;
    }

    public Employee findById(String id){
        return (Employee) repository.findById(id);
    }
}
