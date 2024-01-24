package exercise7;

import java.util.Random;

public class CreateCard {
    public static int[] createArray(int N, int M) {
        int[] array = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(M) + 1;
            for (int j = 0; j < i; j++) {
                if (array[i] == array[j]) {
                    i--;
                    break;
                }
            }

        }
        return array;
    }

    public static Card[] createCard() {
        int[] rankArray = createArray(13, 13);
        String[] ranks = new String[13];
        for (int i = 0; i < rankArray.length; i++) {
            switch (rankArray[i]) {
                case 1:
                    ranks[i] = "A";
                    break;
                case 11:
                    ranks[i] = "J";
                    break;
                case 12:
                    ranks[i] = "Q";
                    break;
                case 13:
                    ranks[i] = "K";
                    break;
                default:
                    ranks[i] = String.valueOf(rankArray[i]);
            }
        }
        int[] suitArray = createArray(4, 4);
        String[] suits = new String[4];
        for (int i = 0; i < suitArray.length; i++) {
            switch (suitArray[i]) {
                case 1:
                    suits[i] = "hearts";
                    break;
                case 2:
                    suits[i] = "diamonds";
                    break;
                case 3:
                    suits[i] = "clubs";
                    break;
                case 4:
                    suits[i] = "spades";
                    break;
            }
        }
        Card[] cards = new Card[52];
        int count = 0;
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cards[count] = new Card(ranks[i], suits[j]);
                count++;
            }
        }
        return cards;
    }

    public static void shuffleCards(Card[] cards) {
        Random rand = new Random();
        int j;
        for (int i = 0; i < 52; i++) {
            j = rand.nextInt(52);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public static void main(String[] args) {
        Card[] cards = createCard();
        shuffleCards(cards);
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i].toString());
        }

    }

}
