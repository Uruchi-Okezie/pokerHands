import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.example.Card;
import org.example.HandValue;
import org.junit.Test;


import static org.junit.Assert.*;

public class HandValueTest {
    @Test
    public void testIsRoyalFlush() {
        HandValue handValue = new HandValue();

        // Test a valid royal flush
        List<Card> royalFlushHand = new ArrayList<>();
        royalFlushHand.add(new Card("10", "Spades"));
        royalFlushHand.add(new Card("J", "Spades"));
        royalFlushHand.add(new Card("Q", "Spades"));
        royalFlushHand.add(new Card("K", "Spades"));
        royalFlushHand.add(new Card("A", "Spades"));
        assertTrue(handValue.isRoyalFlush(royalFlushHand));

        // Test a non-royal flush
        List<Card> nonRoyalFlushHand = new ArrayList<>();
        nonRoyalFlushHand.add(new Card("10", "Spades"));
        nonRoyalFlushHand.add(new Card("J", "Hearts"));
        nonRoyalFlushHand.add(new Card("Q", "Spades"));
        nonRoyalFlushHand.add(new Card("K", "Spades"));
        nonRoyalFlushHand.add(new Card("A", "Spades"));
        assertFalse(handValue.isRoyalFlush(nonRoyalFlushHand));
    }
    @Test
    public void testIsStraightFlush() {
        HandValue handValue = new HandValue();

        // Test a valid straight flush
        List<Card> straightFlushHand = new ArrayList<>();
        straightFlushHand.add(new Card("2", "Hearts"));
        straightFlushHand.add(new Card("3", "Hearts"));
        straightFlushHand.add(new Card("4", "Hearts"));
        straightFlushHand.add(new Card("5", "Hearts"));
        straightFlushHand.add(new Card("6", "Hearts"));
        assertTrue(handValue.isStraightFlush(straightFlushHand));

        // Test a valid straight flush with Ace high
        List<Card> aceHighStraightFlushHand = new ArrayList<>();
        aceHighStraightFlushHand.add(new Card("10", "Spades"));
        aceHighStraightFlushHand.add(new Card("J", "Spades"));
        aceHighStraightFlushHand.add(new Card("Q", "Spades"));
        aceHighStraightFlushHand.add(new Card("K", "Spades"));
        aceHighStraightFlushHand.add(new Card("A", "Spades"));
        assertTrue(handValue.isStraightFlush(aceHighStraightFlushHand));

        // Test a non-straight flush hand
        List<Card> nonStraightFlushHand = new ArrayList<>();
        nonStraightFlushHand.add(new Card("2", "Hearts"));
        nonStraightFlushHand.add(new Card("3", "Hearts"));
        nonStraightFlushHand.add(new Card("4", "Hearts"));
        nonStraightFlushHand.add(new Card("5", "Hearts"));
        nonStraightFlushHand.add(new Card("7", "Hearts"));
        assertFalse(handValue.isStraightFlush(nonStraightFlushHand));
    }


    @Test
    public void testIsFourOfAKind() {
        HandValue handValue = new HandValue();

        // Test a valid four of a kind hand
        List<Card> fourOfAKindHand = new ArrayList<>();
        fourOfAKindHand.add(new Card("10", "Hearts"));
        fourOfAKindHand.add(new Card("10", "Diamonds"));
        fourOfAKindHand.add(new Card("10", "Clubs"));
        fourOfAKindHand.add(new Card("10", "Spades"));
        fourOfAKindHand.add(new Card("J", "Hearts"));
        assertTrue(handValue.isFourOfAKind(fourOfAKindHand));

        // Test a non-four of a kind hand
        List<Card> nonFourOfAKindHand = new ArrayList<>();
        nonFourOfAKindHand.add(new Card("10", "Hearts"));
        nonFourOfAKindHand.add(new Card("10", "Diamonds"));
        nonFourOfAKindHand.add(new Card("J", "Clubs"));
        nonFourOfAKindHand.add(new Card("10", "Spades"));
        nonFourOfAKindHand.add(new Card("J", "Hearts"));
        assertFalse(handValue.isFourOfAKind(nonFourOfAKindHand));
    }

    @Test
    public void testIsFullHouse() {
        HandValue handValue = new HandValue();

        // Test a valid full house
        List<Card> fullHouseHand = Arrays.asList(
                new Card("A", "Hearts"),
                new Card("A", "Diamonds"),
                new Card("A", "Clubs"),
                new Card("K", "Spades"),
                new Card("K", "Clubs")
        );
        assertTrue(handValue.isFullHouse(fullHouseHand));

        // Test a non-full house hand
        List<Card> nonFullHouseHand = Arrays.asList(
                new Card("A", "Hearts"),
                new Card("A", "Diamonds"),
                new Card("K", "Clubs"),
                new Card("K", "Spades"),
                new Card("Q", "Clubs")
        );
        assertFalse(handValue.isFullHouse(nonFullHouseHand));
    }

    @Test
    public void testIsFlush() {
        HandValue handValue = new HandValue();

        // Test a flush with all cards of Hearts
        List<Card> flushHandHearts = new ArrayList<>();
        flushHandHearts.add(new Card("2", "Hearts"));
        flushHandHearts.add(new Card("5", "Hearts"));
        flushHandHearts.add(new Card("7", "Hearts"));
        flushHandHearts.add(new Card("10", "Hearts"));
        flushHandHearts.add(new Card("A", "Hearts"));
        assertTrue(handValue.isFlush(flushHandHearts));

        // Test a flush with all cards of Diamonds
        List<Card> flushHandDiamonds = new ArrayList<>();
        flushHandDiamonds.add(new Card("3", "Diamonds"));
        flushHandDiamonds.add(new Card("6", "Diamonds"));
        flushHandDiamonds.add(new Card("8", "Diamonds"));
        flushHandDiamonds.add(new Card("K", "Diamonds"));
        flushHandDiamonds.add(new Card("Q", "Diamonds"));
        assertTrue(handValue.isFlush(flushHandDiamonds));

        // Test a non-flush hand
        List<Card> nonFlushHand = new ArrayList<>();
        nonFlushHand.add(new Card("3", "Clubs"));
        nonFlushHand.add(new Card("6", "Hearts"));
        nonFlushHand.add(new Card("8", "Spades"));
        nonFlushHand.add(new Card("K", "Diamonds"));
        nonFlushHand.add(new Card("Q", "Diamonds"));
        assertFalse(handValue.isFlush(nonFlushHand));
    }

    @Test
    public void testIsStraight() {
        HandValue handValue = new HandValue();

            // Test case: Straight hand
            List<Card> straightHand = new ArrayList<>();
            straightHand.add(new Card("T", "Hearts"));
            straightHand.add(new Card("J", "Diamonds"));
            straightHand.add(new Card("Q", "Clubs"));
            straightHand.add(new Card("K", "Spades"));
            straightHand.add(new Card("A", "Hearts"));
            assertTrue(handValue.isStraight(straightHand));
    }


    @Test
    public void testIsThreeOfAKind() {
        HandValue handValue = new HandValue();

        // Test a hand with three of a kind
        List<Card> threeOfAKindHand = Arrays.asList(
                new Card("7", "Hearts"),
                new Card("7", "Diamonds"),
                new Card("7", "Clubs"),
                new Card("2", "Spades"),
                new Card("10", "Hearts")
        );
        assertTrue(handValue.isThreeOfAKind(threeOfAKindHand));

        // Test a hand without three of a kind
        List<Card> nonThreeOfAKindHand = Arrays.asList(
                new Card("9", "Hearts"),
                new Card("K", "Diamonds"),
                new Card("4", "Clubs"),
                new Card("2", "Spades"),
                new Card("10", "Hearts")
        );
        assertFalse(handValue.isThreeOfAKind(nonThreeOfAKindHand));
    }

    @Test
    public void testIsTwoPair() {
        HandValue handValue = new HandValue();

        // Test a valid two pair hand
        List<Card> twoPairHand = new ArrayList<>();
        twoPairHand.add(new Card("2", "Hearts"));
        twoPairHand.add(new Card("2", "Diamonds"));
        twoPairHand.add(new Card("3", "Clubs"));
        twoPairHand.add(new Card("3", "Spades"));
        twoPairHand.add(new Card("4", "Hearts"));
        assertTrue(handValue.isTwoPair(twoPairHand));

        // Test a non-two pair hand
        List<Card> nonTwoPairHand = new ArrayList<>();
        nonTwoPairHand.add(new Card("2", "Hearts"));
        nonTwoPairHand.add(new Card("3", "Diamonds"));
        nonTwoPairHand.add(new Card("4", "Clubs"));
        nonTwoPairHand.add(new Card("5", "Spades"));
        nonTwoPairHand.add(new Card("6", "Hearts"));
        assertFalse(handValue.isTwoPair(nonTwoPairHand));
    }

    @Test
    public void testIsPair() {
        HandValue handValue = new HandValue();

        // Test a valid pair hand
        List<Card> pairHand = new ArrayList<>();
        pairHand.add(new Card("10", "Hearts"));
        pairHand.add(new Card("10", "Diamonds"));
        pairHand.add(new Card("2", "Clubs"));
        pairHand.add(new Card("3", "Spades"));
        pairHand.add(new Card("5", "Hearts"));
        assertTrue(handValue.isPair(pairHand));

        // Test a non-pair hand
        List<Card> nonPairHand = new ArrayList<>();
        nonPairHand.add(new Card("10", "Hearts"));
        nonPairHand.add(new Card("J", "Diamonds"));
        nonPairHand.add(new Card("Q", "Clubs"));
        nonPairHand.add(new Card("K", "Spades"));
        nonPairHand.add(new Card("A", "Hearts"));
        assertFalse(handValue.isPair(nonPairHand));
    }

    @Test
    public void testHighestCardProcessing() {
        HandValue handValue = new HandValue();
        // Test case where player 1 wins
        List<Card> player1WinningHand = new ArrayList<>();
        player1WinningHand.add(new Card("2", "Hearts"));
        player1WinningHand.add(new Card("4", "Diamonds"));
        player1WinningHand.add(new Card("7", "Clubs"));
        player1WinningHand.add(new Card("9", "Spades"));
        player1WinningHand.add(new Card("K", "Hearts"));

        List<Card> player2LosingHand = new ArrayList<>();
        player2LosingHand.add(new Card("2", "Spades"));
        player2LosingHand.add(new Card("4", "Clubs"));
        player2LosingHand.add(new Card("7", "Diamonds"));
        player2LosingHand.add(new Card("9", "Hearts"));
        player2LosingHand.add(new Card("Q", "Hearts"));

        assertEquals(1, handValue.highestCardProcessing(player1WinningHand, player2LosingHand));

        // Test case where player 2 wins
        List<Card> player1LosingHand = new ArrayList<>();
        player1LosingHand.add(new Card("2", "Hearts"));
        player1LosingHand.add(new Card("4", "Diamonds"));
        player1LosingHand.add(new Card("7", "Clubs"));
        player1LosingHand.add(new Card("9", "Spades"));
        player1LosingHand.add(new Card("Q", "Hearts"));

        List<Card> player2WinningHand = new ArrayList<>();
        player2WinningHand.add(new Card("2", "Spades"));
        player2WinningHand.add(new Card("4", "Clubs"));
        player2WinningHand.add(new Card("7", "Diamonds"));
        player2WinningHand.add(new Card("9", "Hearts"));
        player2WinningHand.add(new Card("K", "Hearts"));

        assertEquals(2, handValue.highestCardProcessing(player1LosingHand, player2WinningHand));

        // Test case where it's a tie
        List<Card> tieHand1 = new ArrayList<>();
        tieHand1.add(new Card("2", "Hearts"));
        tieHand1.add(new Card("4", "Diamonds"));
        tieHand1.add(new Card("7", "Clubs"));
        tieHand1.add(new Card("9", "Spades"));
        tieHand1.add(new Card("K", "Hearts"));

        List<Card> tieHand2 = new ArrayList<>();
        tieHand2.add(new Card("2", "Spades"));
        tieHand2.add(new Card("4", "Clubs"));
        tieHand2.add(new Card("7", "Diamonds"));
        tieHand2.add(new Card("9", "Hearts"));
        tieHand2.add(new Card("K", "Hearts"));

        assertEquals(0, handValue.highestCardProcessing(tieHand1, tieHand2));
    }
}