import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.Card;
import org.example.DeckBuilder;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class DeckBuilderTest {

    @Test
    public void testPlayerCards() {
        String line = "2H 3D 4C 5S 6H 7C 8D 9S 10H JC";

        List<Card> expectedPlayer1 = Arrays.asList(
                new Card("2", "H"), new Card("3", "D"), new Card("4", "C"), new Card("5", "S"), new Card("6", "H"));
        List<Card> expectedPlayer2 = Arrays.asList(
                new Card("7", "C"), new Card("8", "D"), new Card("9", "S"), new Card("10", "H"), new Card("J", "C"));

        List<List<Card>> playerCards = DeckBuilder.playerCards(line);
        assertEquals(2, playerCards.size());
        assertEquals(expectedPlayer1, playerCards.get(0));
        assertEquals(expectedPlayer2, playerCards.get(1));
    }
}
