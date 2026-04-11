package exercises.exer8;

import java.time.LocalDate;

public final class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String id, String name, String jobTitle, LocalDate dateOfEmploy, double monthlySalary) {
        super(id, name, jobTitle, dateOfEmploy);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double salary() {
        return monthlySalary;
    }
}
