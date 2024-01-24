package card;

public class TestMain {
    public static void main(String[] args) {
        Card cards = new Card();
        Card[] playingCards = cards.createCards();

        System.out.println("input card:");
        for (int i = 0; i < 52; i++) {
            System.out.println(playingCards[i].toString());
        }

        CompareCard compareCard = new CompareCard();
        compareCard.sort(playingCards, compareCard);
        System.out.println("After sorting:");
        for (int i = 0; i < 52; i++) {
            System.out.println(playingCards[i].toString());
        }
    }
}
