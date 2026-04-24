package exercises.exer11;

public class RegisterEmployeeService{
    private final Repository repository;

    public RegisterEmployeeService(Repository repository) {
        this.repository = repository;
    }

    public void register(Employee e){
        repository.register(e);
    }
}
