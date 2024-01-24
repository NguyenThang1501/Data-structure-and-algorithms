package exercise7;

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
}