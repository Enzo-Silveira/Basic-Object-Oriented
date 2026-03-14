package exercises.exer1;

public class Card {
    String suit;
    String rank;
    boolean visible;

    public String state(){
        return rank + " de " + suit + "\n";
    }
}
