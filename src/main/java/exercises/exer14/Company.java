package exercises.exer14;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Company {
    private final Map<String,Employee> employeeMap; //Refazer esse troço com map
    private final Hire hire;
    private final Fire fire;
    private final GetEmployees getEmployees;
    private final Pay pay;
    private final IncreaseSalary increaseSalary;
    private final AverageSalary averageSalary;

    public Company() {
        this.employeeMap = new HashMap<>();
        this.hire = new Hire(employeeMap);
        this.fire = new Fire(employeeMap);
        this.getEmployees = new GetEmployees(employeeMap);
        this.pay = new Pay(employeeMap);
        this.increaseSalary = new IncreaseSalary(employeeMap);
        this.averageSalary = new AverageSalary(employeeMap);
    }

    public void hire(String id, String name, String jobTitle, double salary){
        hire.hireEmployee(id,name,jobTitle,salary);
    }

    public void fire(String id){
        fire.fireEmployee(id);
    }

    public Map<String, Employee> getEmployees() {
        return getEmployees.getAllEmployees();
    }

    public Map<String, Employee> getEmployees(String jobTitle){
        return getEmployees.getEmployeesByJobTitle(jobTitle);
    }

    public void pay(String id){
        pay.payEmployee(id);
    }

    public void increaseSalary(String id, double salary){
        increaseSalary.increaseSalaryOfEmployee(id,salary);
    }

    public double averageSalary(String jobTitle){
        return averageSalary.averageSalaryByJobTitle(jobTitle);
    }

    public double averageSalary(LocalDate start, LocalDate end){
        return averageSalary.averageSalaryByDate(start,end);
    }
}
