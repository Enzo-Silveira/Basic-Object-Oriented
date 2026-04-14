package exercises.exer9;

public final class Rectangle extends Figure {

    public Rectangle(double width, double length) {
        super(width, length);
    }

    @Override
    public double area() {
        return (super.getX()*super.getY());
    }

    @Override
    public String toString() {
        return String.format("Rectangle{width: %f, length: %f}",getwidth(), getlength());
    }

    public double getwidth() {
        return super.getX();
    }

    public double getlength() {
        return super.getY();
    }
}
