package exercises.exer10;

public class Owl extends Animal {

    public Owl(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Pruuu Pruuu!");
    }
}
