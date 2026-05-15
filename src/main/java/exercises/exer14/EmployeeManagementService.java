package exercises.exer14;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeManagementService {
    private final EmployeeRepository repository;

    public EmployeeManagementService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void fireEmployee(String id){
        if(Objects.equals(id, "") || id == null) throw new NullPointerException("ID cannot be empty");
        repository.deleteBykey(id);
    }

    public void hireEmployee(String id, String name, String jobTitle, double salary){
        if(Objects.equals(id, "") || id == null) throw new NullPointerException("ID cannot be empty");
        if(Objects.equals(name, "") || name == null) throw new NullPointerException("Name cannot be empty");
        if(Objects.equals(jobTitle, "") || jobTitle == null) throw new NullPointerException("JobTitle cannot be empty");
        repository.create(new Employee(id,name,jobTitle,salary, LocalDate.now()));
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public List<Employee> getEmployeesByJobTitle(String jobTitle){
        return repository.findAll().stream().filter(e->e.getJobTitle().equals(jobTitle)).toList();
    }
}
