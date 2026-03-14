package exercises.exer1;

public class Card {

    private String suit;
    private String rank;
    private boolean visible;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.visible = false;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String state() {
        return rank + " de " + suit;
    }
}
