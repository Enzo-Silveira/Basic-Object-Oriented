package exercises.exer1;

public class Deck {

    private Card[] cards;
    private int top; // índice da próxima carta disponível

    public Deck() {

        cards = new Card[52];
        top = 0;

        String[] suits = {"Copas", "Espadas", "Ouros", "Paus"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int index = 0;

        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                cards[index] = new Card(suits[i], ranks[j]);
                index++;
            }
        }
    }


    public Card drawCard() {

        if (top >= cards.length) {
            return null;
        }
        Card c = cards[top];
        top++;

        return c;
    }


    public Card[] drawCards(int quantidade) {
        Card[] drawn = new Card[quantidade];
        for (int i = 0; i < quantidade; i++) {
            drawn[i] = drawCard();
        }
        return drawn;
    }
}
