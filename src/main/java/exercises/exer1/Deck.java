package exercises.exer1;

public class Deck {

     Card[] cards = new Card[52];
     int top = 0;

    String[] suits = {"Copas", "Espadas", "Ouros", "Paus"};
    String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public Deck() {
        int index=0;
        for (int i = 0; i < suits.length; i++) {
            for(int j = 0; j < ranks.length; j++) {
                index = i + j;
                cards[index] = new Card();
                cards[index].suit = suits[i];
                cards[index].rank = ranks[j];
                cards[index].visible = false;
            }
        }
    }

    public void drawCard() {

        if (top < cards.length) {
            cards[top].visible = true;
            System.out.println(cards[top].state());
            top++;
        }else {
            System.out.println("Baralho vazio. \n");
        }
    }

    // Pegar várias cartas
    public void drawCards(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            if(top < cards.length) {
                drawCard();
            }
        }
    }

    public int remainingCards() {
        return cards.length - top;
    }
}

