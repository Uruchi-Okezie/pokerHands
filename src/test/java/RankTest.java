import static org.junit.Assert.assertEquals;

import org.example.Rank;
import org.junit.Test;

public class RankTest {

    @Test
    public void testValues() {
        assertEquals(10, Rank.ROYAL_FLUSH.getValue());
        assertEquals(9, Rank.STRAIGHT_FLUSH.getValue());
        assertEquals(8, Rank.FOUR_OF_A_KIND.getValue());
        assertEquals(7, Rank.FULL_HOUSE.getValue());
        assertEquals(6, Rank.FLUSH.getValue());
        assertEquals(5, Rank.STRAIGHT.getValue());
        assertEquals(4, Rank.THREE_OF_A_KIND.getValue());
        assertEquals(3, Rank.TWO_PAIR.getValue());
        assertEquals(2, Rank.PAIR.getValue());
        assertEquals(1, Rank.HIGH_CARD.getValue());
    }
}
