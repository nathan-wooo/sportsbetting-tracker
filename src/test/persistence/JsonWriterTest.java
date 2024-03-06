package persistence;

import model.Bets;
import model.BettingHistory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            BettingHistory bh = new BettingHistory();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyBettingHistory() {
        try {
            BettingHistory bh = new BettingHistory();
            JsonWriter writer = new JsonWriter("data/testWriterEmptyBettingHistory.json");
            writer.open();
            writer.write(bh);
            writer.close();

            JsonReader reader = new JsonReader("data/testWriterEmptyBettingHistory.json");
            bh = reader.read();
            assertEquals(0, bh.totalLosses());
            assertEquals(0, bh.totalWins());
            assertEquals(0, bh.totalProfit());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralBettingHistory() {
        try {
            BettingHistory bh = new BettingHistory();
            bh.add(new Bets("LeBron James Over 10.5 Points", 1000, 2, true));
            bh.add(new Bets("Anthony Davis Over 500.5 Points", 1, 10, true));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralBettingHistory.json");
            writer.open();
            writer.write(bh);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralBettingHistory.json");
            bh = reader.read();
            List<Bets> bets = bh.getBets();
            assertEquals(2, bets.size());
            checkThingy("LeBron James Over 10.5 Points", 1000, 2, 1000, true,
                    bets.get(0));
            checkThingy("Anthony Davis Over 500.5 Points", 9, 10, 1, true,
                    bets.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}