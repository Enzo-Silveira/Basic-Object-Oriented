package exercises.exer11;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Employee employee1 = new Employee("1","employee1","Job1",1000, LocalDate.now());
        Employee employee2 = new Employee("2","employee2","Job2",2000, LocalDate.now());
        Employee employee3 = new Employee("3","employee3","Job3",3000, LocalDate.now());

        FakeEmployeeRepository fake = new FakeEmployeeRepository();
        RegisterEmployeeService register = new RegisterEmployeeService(fake);
        FindEmployeeService find = new FindEmployeeService(fake);

        register.register(employee1);
        register.register(employee2);
        register.register(employee3);

        Employee test = find.findById("1");
        System.out.println(test.getName());

        test = find.findById("2");
        System.out.println(test.getName());

        test = find.findById("3");
        System.out.println(test.getName());

    }
}
