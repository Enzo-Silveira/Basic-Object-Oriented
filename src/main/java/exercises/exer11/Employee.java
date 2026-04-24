package exercises.exer11;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee {
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getYearsOfService(){
        return Period.between(dateOfEmployment,LocalDate.now()).getYears();
    }

    public double calculateBonus(){
        return salary* 1+(getYearsOfService()/10.0);
    }

    @Override
    public boolean equals(Object o) {
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
