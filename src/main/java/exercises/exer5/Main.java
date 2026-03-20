package exercises.exer5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(NamingConventions.isFollowingConvetion(name, NamingConventions.Convention.VARIABLE));
        System.out.println(NamingConventions.isFollowingConvetion(name, NamingConventions.Convention.CLASS));
        System.out.println(NamingConventions.isFollowingConvetion(name, NamingConventions.Convention.CONSTANT));
        System.out.println(NamingConventions.isFollowingConvetion(name, NamingConventions.Convention.METHOD));

        System.out.println(NamingConventions.fromConstToVariable("UPPER_CASE"));
        System.out.println(NamingConventions.fromConstToVariable("SUUUUPPPPPEEEERRRR_DUUUPPEERRR"));

        System.out.println(NamingConventions.fromVariableToConst(name));

        System.out.println(NamingConventions.isValidJavaIdentifier(name));
    }
}
