import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.example.Card;
import org.junit.Test;


public class CardTest {
    @Test
    public void testConstructor() {
        Card card = new Card(10, "Spades");
        assertEquals(10, card.getValue());
        assertEquals("Spades", card.getSuit());
    }
    @Test
    public void testMakeCard() {
        Card card = Card.makeCard("3H");
        assertEquals(3, card.getValue());
        assertEquals("H", card.getSuit());
    }
    @Test
    public void testEquals() {
        Card card1 = new Card(10, "Spades");
        Card card2 = new Card(10, "Spades");
        Card card3 = new Card(5, "Hearts");
        assertEquals(card1, card2);
        assertNotEquals(card1, card3);
    }
    @Test
    public void testCompareTo() {
        Card card1 = new Card(2, "H");
        Card card2 = new Card(5, "D");
        Card card3 = new Card(2, "C");

        assertEquals(0, card1.compareTo(card3));
        assertEquals(1, card2.compareTo(card1));
        assertEquals(-1, card3.compareTo(card2));
    }
}


