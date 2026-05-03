package exercises.exer13;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main() {
        int index = 1;
        List<Employee> employees;
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
            index = scanner.nextInt();
            scanner.nextLine();
            switch (index){
                case 0:
                    System.out.println("\nSystem closed.\n");
                    break;
                case 1:
                    System.out.println("Id of Employee: \n");
                    String idH = scanner.nextLine();
                    Employee testH = new Employee(idH,null,null,0,null);
                    if(company.getEmployees().contains(testH)){
                        System.out.println("\nInvalid Id.\n");
                        break;
                    }
                    System.out.println("Name of Employee:\n");
                    String name = scanner.nextLine();
                    System.out.println("JobTitle of Employee:\n");
                    String jobTitle = scanner.nextLine();
                    System.out.println("Salary of Employee:\n");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    company.hire(idH,name,jobTitle,salary);
                    if(company.getEmployees().contains(testH)){
                        System.out.println("\nEmployee hired.\n");
                    }else{
                        System.out.println("\nSomething went wrong.\n");
                    }
                    break;
                case 2:
                    System.out.println("Id of Employee: \n");
                    String idF = scanner.nextLine();
                    Employee testF = new Employee(idF,null,null,0,null);
                    if(!company.getEmployees().contains(testF)){
                        System.out.println("\nEmployee does not exist.\n");
                        break;
                    }
                    company.fire(idF);
                    break;
                case 3:
                    employees = company.getEmployees();
                    employees.stream().map(e->e.toString()).forEach(e-> System.out.println(e));
                    break;
                case 4:
                    System.out.println("JobTitle of Employee:\n");
                    String jobTitleGet = scanner.nextLine();
                    employees = company.getEmployees(jobTitleGet);
                    employees.stream().map(e->e.toString()).forEach(e-> System.out.println(e));
                    break;
                case 5:
                    System.out.println("Id of Employee: \n");
                    String idP = scanner.nextLine();
                    Employee testP = new Employee(idP,null,null,0,null);
                    if(!company.getEmployees().contains(testP)){
                        System.out.println("\nInvalid Id.\n");
                        break;
                    }
                    company.pay(idP);
                    break;
                case 6:
                    System.out.println("Id of Employee: \n");
                    String idI = scanner.nextLine();
                    Employee testeI = new Employee(idI,null,null,0,null);
                    if(!company.getEmployees().contains(testeI)){
                        System.out.println("\nInvalid Id.\n");
                        break;
                    }
                    System.out.println("New Salary of Employee:\n");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine();
                    company.increaseSalary(idI,newSalary);
                    break;
                case 7:
                    System.out.println("JobTitle of Employee:\n");
                    String jobTitleA = scanner.nextLine();
                    System.out.println("\nAverage Salary: "+company.averageSalary(jobTitleA));
                    break;
                case 8:
                    System.out.println("Initial Date:\n");
                    System.out.println("Year: ");
                    int YearI = scanner.nextInt();
                    System.out.println("Month: ");
                    int MonthI = scanner.nextInt();
                    System.out.println("Day: ");
                    int DayI = scanner.nextInt();
                    System.out.println("Final Date:\n");
                    System.out.println("Year: ");
                    int YearF = scanner.nextInt();
                    System.out.println("Month: ");
                    int MonthF = scanner.nextInt();
                    System.out.println("Day: ");
                    int DayF = scanner.nextInt();
                    System.out.println("\nAverage Salary: "+company.averageSalary(LocalDate.of(YearI,MonthI,DayI),LocalDate.of(YearF,MonthF,DayF)));
                    break;
                default:
                    System.out.println("\nEntrada invalida.\n");
                    break;
            }
        }
    }
}
