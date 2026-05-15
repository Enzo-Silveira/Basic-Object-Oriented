package exercises.exer14;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.StreamSupport;

public class SalaryManagementService {
    private final EmployeeRepository repository;;

    public SalaryManagementService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public double averageSalaryByJobTitle(String jobTitle){
        if(Objects.equals(jobTitle, "") || jobTitle == null) throw new NullPointerException("JobTitle cannot be empty");
        return repository.findAll().stream().filter(employee -> employee.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary).average().orElse(0);
    }

    public double averageSalaryByDate(LocalDate start, LocalDate end){
        if(start == null) throw new NullPointerException("Start date cannot be empty");
        if(end == null) throw new NullPointerException("End date cannot be empty");
        return repository.findAll().stream()
                .flatMap(e ->
                        StreamSupport.stream(
                                Spliterators.spliteratorUnknownSize(
                                        e.iteratorPaychecks(),
                                        Spliterator.ORDERED
                                ),
                                false
                        )
                )
                .filter(e -> e.getPayday().isAfter(start) &&
                        e.getPayday().isBefore(end))
                .mapToDouble(Paycheck::getSalary)
                .average()
                .orElse(0);
    }

    public void payEmployee(String id){
        repository.findOne(id).ifPresentOrElse(
                e->e.createPaycheck(LocalDate.now()),
                ()->{throw new NoSuchElementException("Employee not found");
        });
    }

    public void increaseSalaryOfEmployee(String id, double salary){
        repository.findOne(id).ifPresentOrElse(
                e->e.setSalary(salary),
                ()->{throw new NoSuchElementException("Employee not found");
                });
    }
}
