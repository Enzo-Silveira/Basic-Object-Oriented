package exercises.exer9;

public final class Circle extends Figure {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Circle{radius: %f}", getRadius());
    }

    @Override
    public double area() {
        return Math.PI*(radius*radius);
    }

    public double getRadius() {
        return radius;
    }
}
