package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BetsTest {

    Bets b1;
    Bets b2;
    Bets b3;

    @BeforeEach
    void runBefore() {

        b2 = new Bets("LeBron James Over 7.5 Assists", 100, 2, false);
        b3 = new Bets("Anthony Davis Over 3.5 Blocks", 100, 2.5, true);
    }
    @Test
    void Bets() {

        b1 = new Bets("LeBron James Over 25.5 Points", 100, 2, true);

        assertEquals(100, b1.getProfit());
        assertEquals(100, b1.getAmountPlaced());
        assertTrue(b1.getWin());
        assertEquals("LeBron James Over 25.5 Points", b1.getBetDesc());

    }
}


