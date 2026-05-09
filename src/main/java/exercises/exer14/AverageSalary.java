package exercises.exer14;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class AverageSalary {
    private final Map<String,Employee> employeeMap;

    public AverageSalary(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public double averageSalaryByJobTitle(String jobTitle){
        if(Objects.equals(jobTitle, "") || jobTitle == null) throw new NullPointerException("JobTitle cannot be empty");
        return Objects.requireNonNull(employeeMap,"Command to calculate the average salary could not access Employees database.")
                .values().stream().filter(employee -> employee.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public double averageSalaryByDate(LocalDate start, LocalDate end){
        if(start == null) throw new NullPointerException("Start date cannot be empty");
        if(end == null) throw new NullPointerException("End date cannot be empty");
        Objects.requireNonNull(employeeMap,"Command to calculate the average salary could not access Employees database.");
        double average = 0;
        int cont = 0;
        for(Employee employee: employeeMap.values()) {
            Iterator<Paycheck> paycheckIterator = employee.iteratorPaychecks();
            while (paycheckIterator.hasNext()) {
                Paycheck paycheck = paycheckIterator.next();
                if(paycheck.getPayday().isAfter(start)&&paycheck.getPayday().isBefore(end)){
                    average = average + paycheck.getSalary();
                    cont++;
                }
            }
        }
        if(cont == 0){
            return 0;
        }else {
            return (double) average/cont;
        }
    }

}
