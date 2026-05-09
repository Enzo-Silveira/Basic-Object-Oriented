package exercises.exer14;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GetEmployees {
    private final Map<String,Employee> employeeMap;

    public GetEmployees(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public Map<String, Employee> getAllEmployees() {
        return Objects.requireNonNull(employeeMap,"Command to get Employees could not access Employees database.");
    }

    public Map<String, Employee> getEmployeesByJobTitle(String jobTitle){
        if(Objects.equals(jobTitle, "") || jobTitle == null) throw new NullPointerException("JobTitle cannot be empty");
        return Objects.requireNonNull(employeeMap,"Command to get Employees could not access Employees database.")
                .entrySet().stream().filter(entry -> entry.getValue().getJobTitle().equals(jobTitle))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
