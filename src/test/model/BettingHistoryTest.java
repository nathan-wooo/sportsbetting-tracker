package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BettingHistoryTest {

    Bets b1;
    Bets b2;
    Bets b3;
    Bets b4;
    Bets b5;

    BettingHistory l1;

    @BeforeEach
    void runBefore() {
        b1 = new Bets("LeBron James Over 25.5 Points", 100, 2, true);
        b2 = new Bets("LeBron James Over 7.5 Assists", 100, 2, false);
        b3 = new Bets("Anthony Davis Over 3.5 Blocks", 100, 2.5, true);
        b4 = new Bets("Steph Curry Under 0.5 Three Pointers", 200, 10, false);
        b5 = new Bets("Ben Simmons Over 0.5 Three Pointers", 10, 100, false);

        l1 = new BettingHistory();
    }

    @Test
    void viewAllBets() {
        l1.add(b1);
        assertEquals("|  Bet Number: 1  |  LeBron James Over 25.5 Points  |" +
                "  You wagered $100.0  |  it had a 2.0 multiplier!  |  You won $100.0!  |", l1.viewAllBets());
        l1.add(b2);
        assertEquals("|  Bet Number: 1  |  LeBron James Over 25.5 Points  |  You wagered $100.0  |"+
                "  it had a 2.0 multiplier!  |  You won $100.0!  ||  Bet Number: 2  |  LeBron James Over 7.5 Assists"+
                "  |  You wagered $100.0  |  it had a 2.0 multiplier!  |  You lost $100.0!  |", l1.viewAllBets());

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

    @Test
    void totalWins() {
        l1.add(b1);
        l1.add(b2);
        l1.add(b4);
        assertEquals(1, l1.totalWins());
        l1.add(b3);
        assertEquals(2, l1.totalWins());
    }

    @Test
    void totalLosses() {
        l1.add(b1);
        l1.add(b2);
        l1.add(b4);
        assertEquals(2, l1.totalLosses());
        l1.add(b3);
        assertEquals(2, l1.totalLosses());
        l1.add(b5);
        assertEquals(3, l1.totalLosses());

    }

    @Test
    void largestWin() {
        l1.add(b1);
        l1.add(b2);
        l1.add(b3);
        l1.add(b4);
        l1.add(b5);
        assertEquals(150, l1.largestWin());

    }

    @Test
    void largestLoss() {
        l1.add(b1);
        l1.add(b2);
        l1.add(b3);
        l1.add(b4);
        l1.add(b5);
        assertEquals(-200, l1.largestLoss());

    }

}
