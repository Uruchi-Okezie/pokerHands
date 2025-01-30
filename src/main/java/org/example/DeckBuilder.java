package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeckBuilder {
    public static List<List<Card>> playerCards(String line){
        String[] cards = line.split(" ");
        List<Card> player1 = Arrays.asList(cards).subList(0,5).stream().map(Card::makeCard).collect(Collectors.toList());
        List<Card> player2 = Arrays.asList(cards).subList(5,10).stream().map(Card::makeCard).collect(Collectors.toList());
        return Arrays.asList(player1, player2);
    }
}
