package exercises.exer8;

import java.time.LocalDate;
import java.util.Objects;

public abstract sealed class Employee permits FullTimeEmployee, PerHourEmployee{
    private String id;
    private String name;
    private String jobTitle;
    private LocalDate dateOfEmploy;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmploy) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmploy = dateOfEmploy;
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
                ", dateOfEmploy=" + dateOfEmploy +
                '}';
    }

    public abstract double salary();
}
