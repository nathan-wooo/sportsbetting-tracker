package persistence;

import model.Bets;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkThingy(String betDesc, double profit, double odds,
                               double amountPlaced, Boolean win, Bets bets) {
        assertEquals(betDesc, bets.getBetDesc());
        assertEquals(profit, bets.getProfit());
        assertEquals(odds, bets.getOdds());
        assertEquals(amountPlaced, bets.getAmountPlaced());
        assertEquals(win, bets.getWin());
    }
}