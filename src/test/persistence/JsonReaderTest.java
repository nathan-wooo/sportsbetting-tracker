package persistence;

import model.Bets;
import model.BettingHistory;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            BettingHistory bh = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("data/testReaderEmptyBettingHistory");
        try {
            BettingHistory bh = reader.read();
            assertEquals(0, bh.totalProfit());
            assertEquals(0, bh.totalLosses());
            assertEquals(0, bh.totalWins());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("data/testReaderGeneralBettingHistory");
        try {
            BettingHistory bh = reader.read();
            List<Bets> bettingHistory = bh.getBets();
            assertEquals(2, bh.totalWins());
            checkThingy("LeBron James Over 10.5 Points", 1000, 2, 1000, true, bettingHistory.get(0));
            checkThingy("Anthony Davis Over 500.5 Points", 9, 10, 1, true, bettingHistory.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}