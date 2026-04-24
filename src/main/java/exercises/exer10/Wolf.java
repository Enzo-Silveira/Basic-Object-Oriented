package exercises.exer10;

public class Wolf extends Animal {

    public Wolf(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Auuuuuu!");
    }
    public void run(){
        System.out.println("Wolf is running!");
    }
}
