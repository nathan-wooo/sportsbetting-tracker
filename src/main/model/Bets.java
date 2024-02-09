package model;

import java.util.ArrayList;

// Represents a bet having a description of the bet, amount of money placed on it, the odds,
// whether it was a win or loss, and the  profit or loss made from the bet
public class Bets {

    protected String betDesc;
    protected double amountPlaced;
    protected double odds;
    protected boolean win; // true is win, false is loss
    protected double profit;

    // EFFECTS: constructs a bet with given description, amount placed, odds, whether win or loss,
    // and calculates the profit from the bet
    public Bets(String betDesc, double amountPlaced, double odds, boolean win) {
        this.betDesc = betDesc;
        this.amountPlaced = amountPlaced;
        this.odds = odds;
        this.win = win;
        if (win) {
            profit = amountPlaced * odds - amountPlaced;
        } else {
            profit = -(amountPlaced);
        }
    }

    public String getBetDesc() {
        return betDesc;
    }

    public double getAmountPlaced() {
        return amountPlaced;
    }

    public double getOdds() {
        return odds;
    }

    public boolean getWin() {
        return win;
    }

    public double getProfit() {
        return profit;
    }
}
