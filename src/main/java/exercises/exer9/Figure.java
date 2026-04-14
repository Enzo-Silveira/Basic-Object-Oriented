package exercises.exer9;

public abstract sealed class Figure permits Circle, Rectangle, Triangle {
    private double x;
    private double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
