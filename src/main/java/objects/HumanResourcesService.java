package objects;

public class HumanResourcesService {
    void main(){
        // Declares the variable and instantiates the object using "new" keyword. Also, it sets the object state.
        Employee employeeToHire = new Employee("SC303234", "Alan Turing", 9000.0, "Jr. Software Engineer", 5);
        employeeToHire.increaseSalary(10.0); // sends a message to increase the salary by 10%
        System.out.println(employeeToHire.salary); // 9900.0

        // only declares a variable of type Employee
        Employee otherEmployee;
        // otherEmployee = new Employee(); // instantiates the object with default state
        //System.out.println(otherEmployee.salary); // Error! 'java: variable otherEmployee might not have been initialized'

        // Creates an array to point to three instances. All elements in the array currently point to null
        Employee[] staff = new Employee[3];
        // Stores in index 0 a reference to the memory (heap) that contains the actual object
        staff[0] = new Employee("SC323234", "John von Neumann", 9000.0, "Staff Engineer", 25);
        System.out.println(staff[0].calculateBonus()); // 3801.1485
        //System.out.println(staff[1].calculateBonus());
        //Exception in thread "main" java.lang.NullPointerException: Cannot invoke "class03.Employee.calculateBonus()" because "staff[1]" is null

        Computer newEmployeeComputer = new Computer("2321312", "Dell XPS 43", employeeToHire);
        employeeToHire.setComputer(newEmployeeComputer);
        // employeeToHire => newEmployeeComputer => 'brand' attribute
        System.out.println(employeeToHire.getComputer().brand);
        // newEmployeeComputer => employeeToHire => 'name' attribute: Alan Turing
        System.out.println(newEmployeeComputer.getEmployee().name);

        Department department = new Department("Computer Science");
        department.addEmployee(employeeToHire);
    }
}