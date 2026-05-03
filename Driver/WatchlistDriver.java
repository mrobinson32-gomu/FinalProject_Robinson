import java.util.ArrayList;
import java.util.Scanner;

public class WatchlistDriver {
    public static String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> watchlist = new ArrayList<>();

        System.out.println("Do you want to create a TV show or movie watchlist?");
        String choice = scnr.nextLine().toLowerCase();

        while(!choice.equals("movies") && !choice.equals("tv shows")) {
            System.out.println("Please enter 'movies or 'tv shows':");
            choice = scnr.nextLine().toLowerCase();
        }

        System.out.println("Enter your " + choice + ". Type 'end list' to finish.");

        while (true) {
            String item = scnr.nextLine();
            if (item.equalsIgnoreCase("end list")) {
                break;
            }
            watchlist.add(item);
        }

        System.out.println("\n" + capitalize(choice) + " watchlist:");
        for (String item : watchlist) {
            System.out.println("- " + item);
        }
        scnr.close();
    }
}
