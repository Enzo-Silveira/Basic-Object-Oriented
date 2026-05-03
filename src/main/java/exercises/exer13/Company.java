package exercises.exer13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Company {
    private List<Employee> employeeList;

    public Company() {
        this.employeeList = new ArrayList<>();
    }

    public void hire(String id, String name, String jobTitle, double salary){
        employeeList.add(new Employee(id,name,jobTitle,salary, LocalDate.now()));
    }

    public void fire(String id){
        Employee teste = new Employee(id,null,null,0,null);
        employeeList.remove(teste);

    }

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public List<Employee> getEmployees(String jobTitle){
        return employeeList.stream().filter(e -> e.getJobTitle().equals(jobTitle)).toList();
    }

    public void pay(String id){
        employeeList.stream().filter(e -> e.getId().equals(id)).forEach(e->e.createPaycheck(LocalDate.now()));
    }

    public void increaseSalary(String id, double salary){
        employeeList.stream().filter(e->e.getId().equals(id)).forEach(e->e.setSalary(salary));
    }

    public double averageSalary(String jobTitle){
        return employeeList.stream().filter(e -> e.getJobTitle().equals(jobTitle)).mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public double averageSalary(LocalDate start, LocalDate end){
        double average = 0;
        int cont = 0;
        for(Employee employee:employeeList) {
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
