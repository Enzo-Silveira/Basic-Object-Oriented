package exercises.exer14;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class Hire {
    private final Map<String,Employee> employeeMap;

    public Hire(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void hireEmployee(String id, String name, String jobTitle, double salary){
        if(Objects.equals(id, "") || id == null) throw new NullPointerException("ID cannot be empty");
        if(Objects.equals(name, "") || name == null) throw new NullPointerException("Name cannot be empty");
        if(Objects.equals(jobTitle, "") || jobTitle == null) throw new NullPointerException("JobTitle cannot be empty");
        employeeMap.put(id, new Employee(id,name,jobTitle,salary, LocalDate.now()));
    }
}
