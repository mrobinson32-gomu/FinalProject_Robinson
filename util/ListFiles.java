package util;
import model.*;
import java.io.*;

public class ListFiles {
    public static String getFileName(String username, String type) {
        return username + "_" + type + ".txt";
    }

    public static boolean fileExists(String username, String type) {
        return new File(getFileName(username, type)).exists();
    }

    public static void createWatchlistFile(String username, String type) {
        try(PrintWriter writer = new PrintWriter(getFileName(username, type))) {
            writer.println(username + "'s " + type + " watchlist");
        }
        catch (IOException e) {
            System.out.println("Error creating file");
        }
    }

    public static ListItem[] loadWatchlist(String username, String type) {
        ListItem[] items = new ListItem[100];
        int index = 0;

        File file = new File(getFileName(username, type));

        if (!file.exists()) {
            return items;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null && index < items.length) {
                if (type.equalsIgnoreCase("movies")) {
                    items[index++] = new Movie(line);
                }
                else {
                    items [index++] = new TvShow(line);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }

        return items;
    }

    public static void saveWatchlist(String username, String type, ListItem[] items, int count) {
        try (PrintWriter writer = new PrintWriter(getFileName(username, type))) {
            writer.println(username + "'s " + type + " watchlist");

            for (int i = 0; i < count; i++) {
                writer.println(items[i].getTitle());
            }
        }
        catch (IOException e) {
            System.out.println("error saving file");
        }
    }

    public static void saveFinished(String username, String type, ListItem item) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(username + "_finished_" + type + ".txt", true))) {
            writer.println(item.getTitle());
        }
        catch (IOException e) {
            System.out.println("Error saving item");
        }
    }

    public static void printWatchlistFile(String username, String type) {
        File file = new File(getFileName(username, type));

        if (!file.exists()) {
            System.out.println("No watchlists exist yet");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("Error displaying file");
        }
    }

    public static void printFinishedWatchlistFile(String username, String type) {
        File file = new File(username + "_finished_" + type + ".txt");

        if(!file.exists()) {
            System.out.println("No finished " + type + ":");
            return;
        }

        System.out.println(username + "'s finished " + type + ":");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("Error readding list");
        }
    }
}
