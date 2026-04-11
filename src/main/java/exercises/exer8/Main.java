package exercises.exer8;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        FullTimeEmployee employee1 = new FullTimeEmployee("1","employee1","employee1", LocalDate.now(),10000);
        PerHourEmployee employee2 = new PerHourEmployee("2","employee2","employee2",LocalDate.now(),100,10);
        PerHourEmployee employee3 = new PerHourEmployee("1","employee2","employee2",LocalDate.now(),100,10);
        System.out.println(employee1.toString());
        System.out.println(employee1.salary());
        System.out.println(employee2.toString());
        System.out.println(employee2.salary());
        System.out.println(employee1.equals(employee2));
        System.out.println(employee1.equals(employee3));
    }
}
