package exercises.exer10;

public class Wolf extends Animal implements Runner {

    public Wolf(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Auuuuuu!");
    }

    @Override
    public void run(){
        System.out.println("Wolf is running!");
    }
}
