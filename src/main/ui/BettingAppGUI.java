package ui;

import model.Bets;
import model.BettingHistory;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BettingAppGUI extends JFrame {

    private BettingHistory bettingHistory;
    private JTextArea bettingHistoryArea;
    private JLabel totalProfitLabel;
    private JLabel biggestWinLabel;
    private JTextField betDescField;
    private JTextField amountPlacedField;
    private JTextField oddsField;
    private JCheckBox winCheck;

    private static final String JSON_STORE = "./data/bettingHistory.json";

    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    // EFFECTS: Creates main GUI
    public BettingAppGUI() {
        super("Nathan's Betting Tracker");
        setSize(1024, 768);
        setLayout(new GridLayout(2, 3));
        bettingHistory = new BettingHistory();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        JButton loadButton = new JButton("Load Betting History");
        JButton saveButton = new JButton("Save Betting History");
        JButton addBetButton = new JButton("Add Bet");
        totalProfitLabel = new JLabel("Total Profit: $0.0");
        biggestWinLabel = new JLabel("Biggest Win: $0.0");
        bettingHistoryArea = new JTextArea();
        bettingHistoryArea.setEditable(false);
        JScrollPane listScrollPane = new JScrollPane(bettingHistoryArea);
        loadButton.addActionListener(e -> loadBettingHistory());
        saveButton.addActionListener(e -> saveBettingHistory());
        addBetButton.addActionListener(e -> addBet());
        addFourThings(loadButton, totalProfitLabel, listScrollPane, saveButton);
        add(biggestWinLabel);
        add(createAddBetPanel(addBetButton));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addAddWindowListener();
        setVisible(true);
    }

    public void addAddWindowListener() {
        addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        bettingHistory.printLogs();
                        System.exit(0);
                    }
                });
    }

    // EFFECTS: adds button label and pane to GUI
    // helper method for constructor due to checkstyle
    public void addFourThings(JButton button1, JLabel label1, JScrollPane pane1, JButton button2) {
        add(button1);
        add(label1);
        add(pane1);
        add(button2);
    }


    public static void main(String[] args) {
        new BettingAppGUI();
    }

    // EFFECTS: creates panel for adding bets
    private JPanel createAddBetPanel(JButton addBetButton) {
        JPanel panel = new JPanel(new GridLayout(5, 2));
        betDescField = new JTextField();
        amountPlacedField = new JTextField();
        oddsField = new JTextField();
        winCheck = new JCheckBox("Win?");
        panel.add(new JLabel("Bet Description:"));
        panel.add(betDescField);
        panel.add(new JLabel("Amount Placed:"));
        panel.add(amountPlacedField);
        panel.add(new JLabel("Odds:"));
        panel.add(oddsField);
        panel.add(new JLabel("Win?"));
        panel.add(winCheck);
        panel.add(addBetButton);
        return panel;
    }

    // EFFECTS: loads betting history
    private void loadBettingHistory() {
        try {
            bettingHistory = jsonReader.read();
            updateDisplays();
            JOptionPane.showMessageDialog(this, "Betting history loaded successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Unable to read from file: " + ex.getMessage(),
                    "Load Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: saves betting history
    private void saveBettingHistory() {
        try {
            jsonWriter.open();
            jsonWriter.write(bettingHistory);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Betting history saved successfully.");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Unable to write to file: " + ex.getMessage(),
                    "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: Creates new bet and displays jpg image if bet is added successfully
    private void addBet() {
        try {
            String betDesc = betDescField.getText();
            double amountPlaced = Double.parseDouble(amountPlacedField.getText());
            double odds = Double.parseDouble(oddsField.getText());
            boolean win = winCheck.isSelected();
            Bets bet = new Bets(betDesc, amountPlaced, odds, win);
            bettingHistory.add(bet);
            updateDisplays();

            ImageIcon imageIcon = new ImageIcon("./data/funnyMEME.jpg");
            JOptionPane.showMessageDialog(this, "", "Bet Added Successfully",
                    JOptionPane.INFORMATION_MESSAGE, imageIcon);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers for amount and odds.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // EFFECTS: updates displays
    private void updateDisplays() {
        totalProfitLabel.setText("Total Profit: $" + bettingHistory.totalProfit());
        biggestWinLabel.setText("Biggest Win: $" + bettingHistory.largestWin());
        updateBettingHistoryArea();
    }

    // EFFECTS: updates displays of the betting history visual
    private void updateBettingHistoryArea() {
        StringBuilder historyText = new StringBuilder();
        for (Bets bet : bettingHistory.getBettingHistory()) {
            historyText.append("Description: ").append(bet.getBetDesc())
                    .append(", Amount: $").append(bet.getAmountPlaced())
                    .append(", Odds: ").append(bet.getOdds())
                    .append(", Result: ").append(bet.getWin() ? "Win" : "Loss")
                    .append(", Profit: $").append(bet.getProfit())
                    .append("\n");
        }
        bettingHistoryArea.setText(historyText.toString());
    }
}


