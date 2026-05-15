package exercises.exer14;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main() {
        int index = 1;
        EmployeeRepository repository = new EmployeeRepository();
        SalaryManagementService salaryService = new SalaryManagementService(repository);
        EmployeeManagementService employeeService = new EmployeeManagementService(repository);

        while (index != 0) {
            System.out.println("-----------MENU-----------\n" +
                    "Type the desired operation number:\n" +
                    "1 - hire;                   5 - pay;\n" +
                    "2 - fire;                   6 - increaseSalary;\n" +
                    "3 - getAllEmployees;        7 - averageSalaryByTitle;\n" +
                    "4 - getEmployeesByTitle;    8 - averageSalaryByDate;\n" +
                    "0 - Exit;\n");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (!input.matches("\\d+")) {
                continue;
            }
            index = Integer.parseInt(input);
            switch (index) {
                case 0:
                    System.out.println("\nSystem closed.\n");
                    break;
                case 1:

                    System.out.println("Id of Employee: \n");
                    String idH = scanner.nextLine();
                    if (employeeService.getAllEmployees().stream().anyMatch(e -> e.getId().equals(idH))) {
                        System.out.println("\nInvalid Id.\n");
                        break;
                    }
                    System.out.println("Name of Employee:\n");
                    String name = scanner.nextLine();
                    System.out.println("JobTitle of Employee:\n");
                    String jobTitle = scanner.nextLine();
                    System.out.println("Salary of Employee:\n");
                    double salary;
                    input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        continue;
                    }
                    salary = Double.parseDouble(input);
                    employeeService.hireEmployee(idH, name, jobTitle, salary);
                    if (employeeService.getAllEmployees().stream().anyMatch(e -> e.getId().equals(idH))) {
                        System.out.println("\nEmployee hired.\n");
                    }

                    break;
                case 2:

                    System.out.println("Id of Employee: \n");
                    String idF = scanner.nextLine();
                    if (!employeeService.getAllEmployees().stream().anyMatch(e -> e.getId().equals(idF))) {
                        System.out.println("\nEmployee does not exist.\n");
                        break;
                    }
                    employeeService.fireEmployee(idF);
                    if (!employeeService.getAllEmployees().stream().anyMatch(e -> e.getId().equals(idF))) {
                        System.out.println("\nEmployee fired.\n");
                    }

                    break;
                case 3:
                    employeeService.getAllEmployees().stream().map(Employee::toString).forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("JobTitle of Employee:\n");
                    String jobTitleGet = scanner.nextLine();
                    employeeService.getEmployeesByJobTitle(jobTitleGet).stream()
                            .map(Employee::toString).forEach(System.out::println);

                    break;
                case 5:

                    System.out.println("Id of Employee: \n");
                    String idP = scanner.nextLine();
                    if (!employeeService.getAllEmployees().stream().anyMatch(e -> e.getId().equals(idP))) {
                        System.out.println("\nInvalid Id.\n");
                        break;
                    }
                    salaryService.payEmployee(idP);
                    System.out.println("\n Payment done.\n");

                    break;
                case 6:

                    System.out.println("Id of Employee: \n");
                    String idI = scanner.nextLine();
                    if (!employeeService.getAllEmployees().stream().anyMatch(e -> e.getId().equals(idI))) {
                        System.out.println("\nInvalid Id.\n");
                        break;
                    }
                    System.out.println("New Salary of Employee:\n");
                    double newSalary;
                    input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        System.out.println("\nEntrada invalida.\n");
                        break;
                    }
                    newSalary = Double.parseDouble(input);
                    salaryService.increaseSalaryOfEmployee(idI, newSalary);

                    break;
                case 7:

                    System.out.println("JobTitle of Employee:\n");
                    String jobTitleA = scanner.nextLine();
                    System.out.println("\nAverage Salary: " + salaryService.averageSalaryByJobTitle(jobTitleA));

                    break;
                case 8:

                    int YearI = 0;
                    int MonthI = 0;
                    int DayI = 0;
                    int YearF = 0;
                    int MonthF = 0;
                    int DayF = 0;

                    System.out.println("Initial Date:\n");
                    System.out.println("Year: ");
                    input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        System.out.println("\nEntrada invalida.\n");
                        break;
                    }
                    YearI = Integer.parseInt(input);

                    System.out.println("Month: ");
                    input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        System.out.println("\nEntrada invalida.\n");
                        break;
                    }
                    MonthI = Integer.parseInt(input);

                    System.out.println("Day: ");
                    input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        System.out.println("\nEntrada invalida.\n");
                        break;
                    }
                    DayI = Integer.parseInt(input);

                    System.out.println("Final Date:\n");
                    System.out.println("Year: ");
                    input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        System.out.println("\nEntrada invalida.\n");
                        break;
                    }
                    YearF = Integer.parseInt(input);

                    System.out.println("Month: ");
                    input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        System.out.println("\nEntrada invalida.\n");
                        break;
                    }
                    MonthF = Integer.parseInt(input);

                    System.out.println("Day: ");
                    input = scanner.nextLine();
                    if (!input.matches("\\d+")) {
                        System.out.println("\nEntrada invalida.\n");
                        break;
                    }
                    DayF = Integer.parseInt(input);

                    System.out.println("\nAverage Salary: " + salaryService.averageSalaryByDate(LocalDate.of(YearI, MonthI, DayI), LocalDate.of(YearF, MonthF, DayF)));

                    break;
                default:
                    System.out.println("\nEntrada invalida.\n");
                    break;
            }
        }
    }
}
