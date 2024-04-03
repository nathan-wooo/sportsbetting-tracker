package persistence;

import model.Bets;
import model.BettingHistory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Event;
import model.EventLog;
import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BettingHistory read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBettingHistory(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        EventLog.getInstance().logEvent(new Event("Bets loaded"));
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses bettingHistory from JSON object and returns it
    private BettingHistory parseBettingHistory(JSONObject jsonObject) {
        BettingHistory bh = new BettingHistory();
        addBettingHistory(bh, jsonObject);
        return bh;
    }

    // MODIFIES: bh
    // EFFECTS: parses bets from JSON object and adds them to bettingHistory
    private void addBettingHistory(BettingHistory bh, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("bettingHistory");
        for (Object json : jsonArray) {
            JSONObject nextBet = (JSONObject) json;
            addBets(bh, nextBet);
        }
    }

    // MODIFIES: bh
    // EFFECTS: parses bet from JSON object and adds it to bettingHistory
    private void addBets(BettingHistory bh, JSONObject jsonObject) {
        String betDesc = jsonObject.getString("betDesc");
        Double amountPlaced = jsonObject.getDouble("amountPlaced");
        Double odds = jsonObject.getDouble("odds");
        Boolean win = jsonObject.getBoolean("win");
        Bets bet = new Bets(betDesc, amountPlaced, odds, win);
        bh.add(bet);
    }
}