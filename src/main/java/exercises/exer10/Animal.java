package exercises.exer10;

public abstract class Animal{
    private String name;
    public abstract void makeSound();

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
