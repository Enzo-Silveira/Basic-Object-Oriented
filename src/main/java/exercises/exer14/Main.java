package exercises.exer14;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main() {
        int index = 1;
        Map<String, Employee> employees;
        Company company = new Company();
        while(index != 0) {
            System.out.println("-----------MENU-----------\n" +
                    "Type the desired operation number:\n" +
                    "1 - hire;                   5 - pay;\n" +
                    "2 - fire;                   6 - increaseSalary;\n" +
                    "3 - getAllEmployees;        7 - averageSalaryByTitle;\n" +
                    "4 - getEmployeesByTitle;    8 - averageSalaryByDate;\n" +
                    "0 - Exit;\n");
            Scanner scanner = new Scanner(System.in);
            try {
                index = scanner.nextInt();
            } catch (Exception e) {
                index = -1;
            }
            scanner.nextLine();
            switch (index){
                case 0:
                    System.out.println("\nSystem closed.\n");
                    break;
                case 1:
                    try {
                        System.out.println("Id of Employee: \n");
                        String idH = scanner.nextLine();
                        if(company.getEmployees().containsKey(idH)){
                            System.out.println("\nInvalid Id.\n");
                            break;
                        }
                        System.out.println("Name of Employee:\n");
                        String name = scanner.nextLine();
                        System.out.println("JobTitle of Employee:\n");
                        String jobTitle = scanner.nextLine();
                        System.out.println("Salary of Employee:\n");
                        double salary = 0;
                        try {
                            salary = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid salary entry.");
                            break;
                        }
                        scanner.nextLine();
                        company.hire(idH,name,jobTitle,salary);
                        System.out.println("\nEmployee hired.\n");
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    try {
                        System.out.println("Id of Employee: \n");
                        String idF = scanner.nextLine();
                        if(!company.getEmployees().containsKey(idF)){
                            System.out.println("\nEmployee does not exist.\n");
                            break;
                        }
                        company.fire(idF);
                        System.out.println("\nEmployee fired.\n");
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        employees = company.getEmployees();
                        employees.values().stream().map(Employee::toString).forEach(e-> System.out.println(e));
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("JobTitle of Employee:\n");
                        String jobTitleGet = scanner.nextLine();
                        employees = company.getEmployees(jobTitleGet);
                        employees.values().stream().map(e->e.toString()).forEach(e-> System.out.println(e));
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Id of Employee: \n");
                        String idP = scanner.nextLine();
                        if(!company.getEmployees().containsKey(idP)){
                            System.out.println("\nInvalid Id.\n");
                            break;
                        }
                        company.pay(idP);
                        System.out.println("\n Payment done.\n");
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Id of Employee: \n");
                        String idI = scanner.nextLine();
                        if(!company.getEmployees().containsKey(idI)){
                            System.out.println("\nInvalid Id.\n");
                            break;
                        }
                        System.out.println("New Salary of Employee:\n");
                        double newSalary = 0;
                        try {
                            newSalary = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid salary entry.");
                            break;
                        }
                        scanner.nextLine();
                        company.increaseSalary(idI,newSalary);
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    try {
                        System.out.println("JobTitle of Employee:\n");
                        String jobTitleA = scanner.nextLine();
                        System.out.println("\nAverage Salary: "+company.averageSalary(jobTitleA));
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        int YearI = 0;
                        int MonthI = 0;
                        int DayI = 0;
                        int YearF = 0;
                        int MonthF = 0;
                        int DayF = 0;
                        try {
                            System.out.println("Initial Date:\n");
                            System.out.println("Year: ");
                            YearI = scanner.nextInt();
                            System.out.println("Month: ");
                            MonthI = scanner.nextInt();
                            System.out.println("Day: ");
                            DayI = scanner.nextInt();
                            System.out.println("Final Date:\n");
                            System.out.println("Year: ");
                            YearF = scanner.nextInt();
                            System.out.println("Month: ");
                            MonthF = scanner.nextInt();
                            System.out.println("Day: ");
                            DayF = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Date entry.");
                            break;
                        }
                        System.out.println("\nAverage Salary: "+company.averageSalary(LocalDate.of(YearI,MonthI,DayI),LocalDate.of(YearF,MonthF,DayF)));
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("\nEntrada invalida.\n");
                    break;
            }
        }
    }
}
