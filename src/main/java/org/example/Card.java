package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Card implements Comparable<Card> {
    private int value;
    private String suit;

    public Card(String value, String suit) {
        switch (value) {
            case "T" -> this.value = 10;
            case "J" -> this.value = 11;
            case "Q" -> this.value = 12;
            case "K" -> this.value = 13;
            case "A" -> this.value = 14;
            default -> this.value = Integer.parseInt(value);

        }
        this.suit = suit;
    }

    public static Card makeCard(String card) {
        String value = card.substring(0, card.length() - 1);
        String suit = card.substring(card.length() - 1);
        return new Card(value, suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return value == card.value && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
    }

    @Override
    public int compareTo(Card o) {
        if (this.value == o.value) {
            return 0;
        } else if (this.value > o.value) {
            return 1;
        } else {
            return -1;
        }
    }
}
