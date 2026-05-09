package exercises.exer14;

import java.util.Map;
import java.util.Objects;

public class IncreaseSalary {
    private final Map<String,Employee> employeeMap;

    public IncreaseSalary(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void increaseSalaryOfEmployee(String id, double salary){
        if(Objects.equals(id, "") || id == null) throw new NullPointerException("ID cannot be empty");
        if(salary < employeeMap.get(id).getSalary()){
            System.out.println("New salary cannot be smaller than current salary of: "+employeeMap.get(id).getSalary());
            return;
        }
        employeeMap.get(id).setSalary(salary);
        System.out.println("New Salary of Employee is assigned\n");
    }
}
