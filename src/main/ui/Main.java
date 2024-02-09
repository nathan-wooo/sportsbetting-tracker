package ui;

import model.BettingHistory;
import model.Bets;

public class Main {
    public static void main(String[] args) {

        BettingHistory listOfBets = new BettingHistory();

        listOfBets.add(new Bets("LeBron James Over 10.5 Points", 10, 2, true));
        listOfBets.add(new Bets("LeBron James Under 7.5 Assists", 10, 2, false));

    }


}
