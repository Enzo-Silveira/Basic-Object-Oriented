package exercises.exer7;

public final class Triangle extends Figure{
    private double a;
    private double b;
    private double c;

    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
