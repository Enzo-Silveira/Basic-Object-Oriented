package interfaces;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String name;
    private LocalDate dateOfEmployment;
    private LocalDate birthDate;

    public Employee(String name, LocalDate dateOfEmployment, LocalDate birthDate) {
        this.name = name;
        this.dateOfEmployment = dateOfEmployment;
        this.birthDate = birthDate;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfService() {
        return Period.between(dateOfEmployment,LocalDate.now()).getYears();
    }
    // rest
}
