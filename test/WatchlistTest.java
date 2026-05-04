package test;
import model.*;
import util.*;
import java.io.File;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class WatchlistTest {
    @Test
    public void testEqualsSameTitle() {
        Movie m1 = new Movie("Interstellar");
        Movie m2 = new Movie("Interstellar");

        assertEquals(m1, m2);
    }

    @Test
    public void testEqualsDifferentTitle() {
        Movie m1 = new Movie("Fight Club");
        Movie m2 = new Movie("Avengers");
        
        assertNotEquals(m1, m2);
    }

    @Test
    public void testMarkFinished() {
        TvShow show = new TvShow("One Piece");
        show.markFinished();

        assertTrue(show.isFinished());
    }

    @Test
    public void testArrayStoresItem() {
        Watchlist list = new Watchlist("John");

        list.addItem(new TvShow("Dragon Ball"));
        ListItem[] items = list.getItems();

        assertEquals("Dragon Ball", items[0].getTitle());
    }

    @Test
    public void testFileCreation() {
        String username = "Tanka Jahari";
        String type = "movies";

        ListFiles.createWatchlistFile(username, type);
        File file = new File(username + "_" + type + ".txt");

        assertTrue(file.exists());
    }

    @Test void testFileExists() {
        String username = "Tanka Jahari";
        String type = "movies";

        ListFiles.createWatchlistFile(username, type);

        assertTrue(ListFiles.fileExists(username, type));
    }


}