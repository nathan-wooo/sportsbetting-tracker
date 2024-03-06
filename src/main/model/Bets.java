package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a bet having a description of the bet, amount of money placed on it, the odds,
// whether it was a win or loss, and the  profit or loss made from the bet
public class Bets implements Writable {

    protected String betDesc; // description of the bet
    protected double amountPlaced; // amount placed on the bet
    protected double odds; // odds of the bet
    protected boolean win; // true is win, false is loss
    protected double profit; // amount won or loss from the bet, calculated with amount placed, odds, and win fields

    // EFFECTS: constructs a bet with given description, amount placed, odds, whether win or loss,
    // and calculates the profit from the bet depending on if boolean win is true or false
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

    // EFFECTS: these are all getters
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("description", betDesc);
        json.put("amountPlaced", amountPlaced);
        json.put("odds", odds);
        json.put("win", win);
        json.put("profit", profit);
        return json;

    }
}