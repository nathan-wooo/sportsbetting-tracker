package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BettingHistoryTest {

    Bets b1;
    Bets b2;
    Bets b3;

    BettingHistory l1;

    @BeforeEach
    void runBefore() {
        b1 = new Bets("LeBron James Over 25.5 Points", 100, 2, true);
        b2 = new Bets("LeBron James Over 7.5 Assists", 100, 2, false);
        b3 = new Bets("Anthony Davis Over 3.5 Blocks", 100, 2.5, true);

        l1 = new BettingHistory();
    }

    @Test
    void totalProfit() {

        l1.add(b1);
        assertEquals(100,l1.totalProfit());
        l1.add(b2);
        assertEquals(0,l1.totalProfit());
        l1.add(b3);
        assertEquals(150, l1.totalProfit());

    }
}
