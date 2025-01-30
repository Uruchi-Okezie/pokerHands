package org.example;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    private static HandValue handValue = new HandValue();

    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/p054_poker.txt";
        int count = 0;
        List<String> lines = FileReader.readFile(path);
        for (String line : lines) {
            List<List<Card>> hands = DeckBuilder.playerCards(line);
            List<Card> player1Hands = hands.get(0);
            List<Card> player2Hands = hands.get(1);
            Collections.sort(player1Hands);
            Collections.sort(player2Hands);
            System.out.println(player1Hands + " " + player2Hands);
            HandValue handValue = new HandValue();
            Rank player1Value = handValue.playerHand(player1Hands);
            System.out.println("Player 1: " + player1Value);
            Rank player2Value = handValue.playerHand(player2Hands);
            System.out.println("Player 2: " + player2Value);

            if (player1Value.getValue() > player2Value.getValue()) {
                ++count;
            } else if (player1Value == player2Value) {
                int result = handValue.highestCardProcessing(player1Hands, player2Hands);
                if (result == 1) {
                    ++count;
                }
            }
        }
        System.out.println("Player 1 won " + count + " hands ");
    }
}
