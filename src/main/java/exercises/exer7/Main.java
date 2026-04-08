package exercises.exer7;

public class Main {
    public static void main(String[] args){
        Circle circle = new Circle(0,0,3);
        Rectangle rectangle = new Rectangle(10,4);
        Triangle triangle = new Triangle(0,0,3,4,5);
        System.out.println(circle.area());
        System.out.println(rectangle.area());
        System.out.println(triangle.area());
    }
}
