package exercises.exer14;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class Pay {
    private final Map<String,Employee> employeeMap;

    public Pay(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void payEmployee(String id){
        if(Objects.equals(id, "") || id == null) throw new NullPointerException("ID cannot be empty");
        Objects.requireNonNull(employeeMap,"Command to pay Employees could not access Employees database.").get(id).createPaycheck(LocalDate.now());
    }
}
