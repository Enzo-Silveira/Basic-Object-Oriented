package exercises.exer7;

public sealed class Figure permits Circle, Rectangle, Triangle{
    private double x;
    private double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double area(){
        return (x*y);
    }
}
