package card;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    public int compare(Card card1, Card card2) {
        if (indexRank(card1) > indexRank(card2)) {
            return 1;
        } else if (indexRank(card1) < indexRank(card2)) {
            return -1;
        } else {
            return indexSuit(card1) - indexSuit(card2);
        }
    }

    public int indexSuit(Card card) {
        switch (card.getSuits()) {
            case "spades":
                return 0;
            case "clubs":
                return 1;
            case "diamonds":
                return 2;
            case "hearts":
                return 3;
        }
        return -1;
    }

    public int indexRank(Card card) {
        switch (card.getRanks()) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
        }
        for (int i = 2; i < 11; i++) {
            if (Integer.parseInt(card.getRanks()) == i) {
                return i;
            }
        }
        return -1;
    }

    public void sort(Card[] a, Comparator<Card> c) {
        for (int i = 0; i < 52; i++) {
            for (int j = 1; j < 52 - i; j++) {
                if (c.compare(a[j - 1], a[j]) > 0) {
                    Card temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
