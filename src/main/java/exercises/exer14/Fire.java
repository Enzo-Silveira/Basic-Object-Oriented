package exercises.exer14;

import java.util.Map;
import java.util.Objects;

public class Fire {
    private final Map<String,Employee> employeeMap;

    public Fire(Map<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void fireEmployee(String id){
        if(Objects.equals(id, "") || id == null) throw new NullPointerException("ID cannot be empty");
        employeeMap.remove(id);
    }
}
