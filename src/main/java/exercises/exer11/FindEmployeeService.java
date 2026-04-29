package exercises.exer11;

public class FindEmployeeService {
    private final Repository<String, Employee> repository;

    public FindEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public Employee findById(String id) {
        if (id == null) {
            return null;
        }
        return repository.findById(id);
    }
}
