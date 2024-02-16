package model;

import java.util.ArrayList;

import static java.lang.Math.abs;

// Represents the entire betting history as an ArrayList of every bet
public class BettingHistory {

    private ArrayList<Bets> bettingHistory;

    // Constructs a list of bets, represents the entire betting history
    public BettingHistory() {

        this.bettingHistory = new ArrayList<Bets>(); //
    }

    // MODIFIES: this
    // EFFECTS: adds a bet to the entire betting history list
    public void add(Bets bets) {

        this.bettingHistory.add(bets);
    }


    // REQUIRES: At least one bet object in list of betting history
    // EFFECTS: Returns a string of data about all bets in betting history list
    public String viewAllBets() {
        int betNum = 1;
        String result = "Nothing";
        double profit = 0;
        String fullString = "";
        for (Bets bet : bettingHistory) {
            if (bet.getWin()) {
                result = "won";
            } else {
                result = "lost";
            }
            profit = abs(bet.getProfit());
            fullString = fullString + "|  Bet Number: " + betNum + "  |  " + bet.getBetDesc() + "  |  You wagered $"
                    + bet.getAmountPlaced() + "  |  it had a " + bet.getOdds() + " multiplier!" + "  |  You "
                    + result + " $" + profit + "!  |\n";
            betNum++;
        }
        return fullString;
    }

    // EFFECTS: adds up the profit of every bet in bettingHistory and returns the total profit
    public double totalProfit() {
        double total = 0;
        for (Bets bet : bettingHistory) {
            total += bet.getProfit();
        }
        return total;
    }

    // EFFECTS: returns total wins
    public int totalWins() {
        int total = 0;
        for (Bets bet : bettingHistory) {
            if (bet.getWin()) {
                total++;
            }
        }
        return total;
    }

    // EFFECTS: returns total losses
    public int totalLosses() {
        int total = 0;
        for (Bets bet : bettingHistory) {
            if (!bet.getWin()) {
                total++;
            }
        }
        return total;
    }

    // REQUIRES: At least one bet won in betting history list
    // EFFECTS: returns largest win
    public double largestWin() {
        double largest = 0;
        for (Bets bet : bettingHistory) {
            if (bet.getProfit() > largest) {
                largest = bet.getProfit();
            }
        }
        return largest;
    }

    // REQUIRES: At least one bet lost in betting history list
    // EFFECTS: returns largest loss
    public double largestLoss() {
        double largest = 0;
        for (Bets bet : bettingHistory) {
            if (bet.getProfit() < largest) {
                largest = bet.getProfit();
            }
        }
        return largest;
    }

    public ArrayList<Bets> getBettingHistory() {
        return bettingHistory;
    }

}
