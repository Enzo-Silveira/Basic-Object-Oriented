package exercises.exer9;

public class Main {
    public static void main(String[] args){
        Circle circle = new Circle(0,0,3);
        Rectangle rectangle = new Rectangle(10,4);
        Triangle triangle = new Triangle(0,0,3,4,5);
        Figure[] figures = new Figure[150];
        double areaSum = 0;
        for(int i = 0;i<50;i++){
            Figure aCircle = new Circle(0,0,i+1);
            figures[i] = aCircle;
            Figure aRectangle = new Rectangle(i+1,i+1);
            figures[50+i] = aRectangle;
            Figure aTriangle = new Triangle(0,0,i+1,i+1,i+1);
            figures[100+i] = aTriangle;
        }
        for(int i = 0;i<150;i++){
            areaSum = areaSum + figures[i].area();
        }
        System.out.println(areaSum);
    }
}
