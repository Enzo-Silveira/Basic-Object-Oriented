package interfaces;

public interface MyInterface {
    int constant = 10; // Implicitly static final, as interfaces do not store state.
    String abstractMethod(); // Must be overridden by all subclasses. Public by default.
    default void defaultMethod(){System.out.println("Do something that has default implementation but can be overridden");}
    static void staticMethod(){System.out.println("Do something that has default implementation and cannot be overridden");}

}
