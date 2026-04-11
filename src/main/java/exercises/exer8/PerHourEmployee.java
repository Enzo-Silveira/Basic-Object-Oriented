package exercises.exer8;

import java.time.LocalDate;

public final class PerHourEmployee extends Employee{
    private double hourlyRate;
    private int workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmploy, double hourlyRate, int workedHour) {
        super(id, name, jobTitle, dateOfEmploy);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    public double salary() {
        return hourlyRate*workedHour;
    }
}
