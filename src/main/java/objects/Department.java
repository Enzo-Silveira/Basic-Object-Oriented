package objects;

public class Department {
    private String name;
    private final Employee[] staff = new Employee[10];
    private int numberOfEmployees; // Auxiliary variable that a client class can not access
    public Department(String name){ this.name = name; }
    public void addEmployee(Employee employee){
        staff[numberOfEmployees++] = employee;
    }

    public void removeEmployee(Employee employee){  }
    public void hasEmployee(Employee employee){  }
    public Employee getEmployee(String employeeId){ return staff[0]; }
}