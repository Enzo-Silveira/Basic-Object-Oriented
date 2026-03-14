package exercises.exer1;

public class Main {

    void main() {

        Deck deck = new Deck();

        Card c1 = deck.drawCard();
        c1.setVisible(true);

        System.out.println(c1.state());

        Card[] varias = deck.drawCards(15);

        for (Card c : varias) {
            if (c != null) {
                c.setVisible(true);
                System.out.println(c.state());
            }
        }
    }
}
