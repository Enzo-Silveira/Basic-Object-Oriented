package objects;

public class Employee {
    String employeeId, name, jobTitle;
    double salary;
    int yearsOfService;
    Computer computer;

    public Employee() { } // default constructor

    public Employee(String employeeId, String name, double salary, String jobTitle, int yearsOfService) { // canonical constructor
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.yearsOfService = yearsOfService;
    }

    void increaseSalary(double percentage){
        int salaryIncrease = (int) (salary * (percentage / 100));
        increaseSalary(salaryIncrease); // it is possible to reuse the implementation of other method overload
    }

    // A method designed to be accessed by other classes in the application
    public void increaseSalary(int amount){
        if( ! isValidAmount(amount)) return;
        salary += amount;
    }

    // An auxiliary method that can only be invoked within the Employee class
    private boolean isValidAmount(int amount){
        return amount >= 0;
    }

//    void increaseSalary(double percentage){
//        salary = salary * (1 + percentage / 100);
//    }
    double calculateBonus(){
        double bonusPercentage = 0.05; // 5% bonus for all employees
        if (yearsOfService >= 5) bonusPercentage += 0.1; // Additional 10% bonus for employees with 5+ of service
        return salary * bonusPercentage;
    }

    public Computer getComputer() {
        return computer;
    }
    public void setComputer(Computer computer) {
        this.computer = computer; // receives a reference by value and assigns it to the computer attribute
    }

    // There is no setter method for employeeId, since it is forbidden to change it.
    public String getEmployeeId() { return employeeId; }
    // There is no setter method for salary, as it can only be increased using the increaseSalary method
    public double getSalary() { return salary; }
    public int getYearsOfService() { return yearsOfService; }
    // Avoid a negative value for yearsOfService
    public void setYearsOfService(int yearsOfService) { this.yearsOfService = Math.max(yearsOfService, 0); }

}
