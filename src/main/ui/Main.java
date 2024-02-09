package ui;

import model.BettingHistory;
import model.Bets;

public class Main {
    public static void main(String[] args) {

        BettingHistory bets = new BettingHistory();

        bets.add(new Bets("LeBron James Over 10.5 Points", 10, 2, true));

        System.out.println(bets.totalProfit());
    }


}
