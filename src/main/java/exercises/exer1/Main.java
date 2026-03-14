package exercises.exer1;

public class Main {
    void main(){
        Deck deck = new Deck();
        deck.drawCard();

        deck.drawCards(5);

        System.out.println(deck.remainingCards());
    }
}
