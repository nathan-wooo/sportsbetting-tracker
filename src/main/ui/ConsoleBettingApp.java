package ui;

import model.Bets;
import model.BettingHistory;
import persistence.JsonReader;
import persistence.JsonWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Bet tracker application
public class ConsoleBettingApp {
    private static final String JSON_STORE = "./data/bettingHistory.json";
    private BettingHistory listOfBets;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the console UI
    public static void main(String[] args) {

        new ConsoleBettingApp();

    }

    // EFFECTS: runs the betting application
    public ConsoleBettingApp() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runBetting();
    }


    // MODIFIES: this
    // EFFECTS: processes user input
    private void runBetting() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nCya later alligator!");
    }

    // MODIFIES: this
    // EFFECTS: initializes betting history
    private void init() {
        this.listOfBets = new BettingHistory();
        this.input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect Options:");
        System.out.println("\tload -> Load betting history");
        System.out.println("\tsave -> Save betting history");
        System.out.println("\ta -> Add Bet");
        System.out.println("\tv -> View Bets");
        System.out.println("\tp -> Total Profit");
        System.out.println("\tw -> Number of Wins");
        System.out.println("\tl -> Number of Losses");
        System.out.println("\tlw -> Largest Win");
        System.out.println("\tll -> Largest Loss");
        System.out.println("\thelp -> Gambling Support");
        System.out.println("\tq -> Quit");

    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            displayCreateBetMenu();
        } else if (command.equals("v")) {
            System.out.println("\n\n\nHere are your bets:\n" + listOfBets.viewAllBets() + "\n\n\n");
        } else if (command.equals("p")) {
            System.out.println("\n\n\nYour total profit is " + listOfBets.totalProfit() + " dollars!\n\n\n");
        } else if (command.equals("w")) {
            System.out.println("\n\n\nOverall, you have won " + listOfBets.totalWins() + " bets!\n\n\n");
        } else if (command.equals("l")) {
            System.out.println("\n\n\nOverall, you have lost " + listOfBets.totalLosses() + " bets!\n\n\n");
        } else if (command.equals("lw")) {
            System.out.println("\n\n\nYour largest win profited: " + listOfBets.largestWin() + "\n\n\n");
        } else if (command.equals("ll")) {
            System.out.println("\n\n\nYour largest loss was: $" + listOfBets.largestLoss() + "\n\n\n");
        } else if (command.equals("help")) {
            System.out.println("\n\n\nPlease call: 1-800-GAMBLER for help \n\n\n");
        } else if (command.equals("load")) {
            loadBettingHistory();
        } else if (command.equals("save")) {
            saveBettingHistory();
        } else {
            System.out.println("\n\n\nSelection not valid...\n\n\n");
        }
    }

    // EFFECTS: displays option menu for creating a bet
    private void displayCreateBetMenu() {
        System.out.println("\nState the description of bet");
        String description = input.next();
        System.out.println("\nState the amount placed on bet");
        double amountPlaced = input.nextDouble();
        System.out.println("\nState the odds on bet");
        double odds = input.nextDouble();
        System.out.println("\nState true if bet won, false if lost");
        boolean won = input.nextBoolean();
        Bets theBet = new Bets(description, amountPlaced, odds, won);
        listOfBets.add(theBet);

    }

    // EFFECTS: saves the betting history to file
    private void saveBettingHistory() {
        try {
            jsonWriter.open();
            jsonWriter.write(listOfBets);
            jsonWriter.close();
            System.out.println("Saved betting history to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
        System.exit(1);
    }

    // MODIFIES: this
    // EFFECTS: loads betting history from file
    private void loadBettingHistory() {
        try {
            listOfBets = jsonReader.read();
            System.out.println("Loaded betting history from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
