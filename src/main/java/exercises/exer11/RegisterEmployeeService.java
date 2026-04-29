package exercises.exer11;

public class RegisterEmployeeService {
    private final Repository<String, Employee> repository;

    public RegisterEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public void register(Employee e) {
        if (e == null || e.getId() == null) {
            return;
        }

        repository.register(e);
    }
}
