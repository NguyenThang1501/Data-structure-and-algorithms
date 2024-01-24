package card;

public class Card {
    private String ranks;
    private String suits;

    public Card() {

    }

    public Card(String ranks, String suits) {
        this.ranks = ranks;
        this.suits = suits;
    }

    public String getRanks() {
        return ranks;
    }

    public void setRanks(String ranks) {
        this.ranks = ranks;
    }

    public String getSuits() {
        return suits;
    }

    public void setSuits(String suits) {
        this.suits = suits;
    }

    @Override
    public String toString() {
        return "Card{" +
                "ranks='" + ranks + '\'' +
                ", suits='" + suits + '\'' +
                '}';
    }

    public Card[] createCards() {
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"hearts", "spades", "diamonds", "clubs"};
        Card[] playingCards = new Card[52];
        int count = 0;
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                playingCards[count] = new Card(ranks[i], suits[j]);
                count++;
            }
        }
        return playingCards;
    }
}
