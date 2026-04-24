package exercises.exer10;

public class Lion extends Animal {

    public Lion(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Rrrrrwaarrr!");
    }
    public void run(){
        System.out.println("Lion is running!");
    }
}
