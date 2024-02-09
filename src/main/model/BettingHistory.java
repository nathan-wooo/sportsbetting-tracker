package model;

import java.util.ArrayList;

// Represents the entire betting history as an ArrayList of every bet
public class BettingHistory {

    private ArrayList<Bets> bettingHistory;

    public BettingHistory() {
        this.bettingHistory = new ArrayList<Bets>();
    }

    // EFFECTS: adds a bet to the entire betting history list
    public void add(Bets bets) {
        this.bettingHistory.add(bets);
    }

    // EFFECTS: adds up the profit of every bet in bettingHistory and returns the total profit
    public double totalProfit() {
        double total = 0;
        for (Bets bet: bettingHistory) {
            total += bet.getProfit();
        }
        return total;
    }

    // EFFECTS: counts total wins
    public int totalWins() {
        int total = 0;
        for (Bets bet: bettingHistory) {
            if (bet.getWin()) {
                total++;
            }
        }
        return total;
    }

    // EFFECTS: counts total losses
    public int totalLosses() {
        int total = 0;
        for (Bets bet: bettingHistory) {
            if (!bet.getWin()) {
                total++;
            }
        }
        return total;
    }
}
