package colections_maps;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Employee implements Comparable<Employee>{
    private String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;
    private Set<TechnicalSkill> skills;
    private List<Paycheck> paychecks;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        paychecks = new ArrayList<>();
    }

    public double getYearsOfService(){
        return Period.between(dateOfEmployment,LocalDate.now()).getYears();
    }

    public double calculateBonus(){
        return salary* 1+(getYearsOfService()/10.0);
    }

    @Override
    public int compareTo(Employee o) {
        return id.compareTo(o.id);
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

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
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

    public Set<TechnicalSkill> getSkills() {
        return skills;
    }

    public void createPaycheck(LocalDate payday){ // Notice that the method restricts the form in which paychecks are added
        paychecks.add(new Paycheck(payday, salary));
    }
    public void removePaycheck(Paycheck paycheck){
        paychecks.remove(paycheck);
    }
    public Iterator<Paycheck> iteratorPaychecks(){
        return paychecks.iterator(); // the Collection provides a method that returns an Iterator of its type
    }


    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
