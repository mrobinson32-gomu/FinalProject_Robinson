package driver;
import model.*;
import util.*;
import java.util.Scanner;
/*  
* Mayson Robinson - MRobinson32  
* CIS171 Online
* Date: 5/4/2026
* Operating System: Windows 11 
* IDE: Visual Studio
* Program Description(short):
* Final project for java, create a watchlist for movies and Tv shows
* Resources used: https://www.w3schools.com/
*/
public class WatchlistDriver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = scnr.nextLine();

        System.out.println("Will your watchlist be Movies or Tv Shows?");
        String type = scnr.nextLine().toLowerCase();

        ListItem[] loadedItems = ListFiles.loadWatchlist(username, type);
        Watchlist watchlist = new Watchlist(username, loadedItems);

        System.out.print("View, view Finished, edit list? ");
        String choice = scnr.nextLine().toLowerCase();

        if (choice.equals("view")) {
            ListFiles.printWatchlistFile(username, type);
        }
        else if (choice.equals("view finished")) {
            ListFiles.printFinishedWatchlistFile(username, type);
        }
        else if (choice.equals("edit")) {
            if (!ListFiles.fileExists(username, type)) {
                ListFiles.createWatchlistFile(username, type);
                System.out.println("New Watchlist created");
            }

            while (true) {
                System.out.print("Add, Finish or End? ");
                String action = scnr.nextLine().toLowerCase();

                if (action.equals("end")){
                    break;
                } 
                if (action.equals("add")) {
                    System.out.print("Enter title: ");
                    String title = scnr.nextLine();

                    ListItem item;
                    
                    if (type.equals("movies")) {
                        item = new Movie(title);
                    }
                    else {
                        item = new TvShow(title);
                    }

                    watchlist.addItem(item);
                }
                else if( action.equals("finish")) {
                    System.out.print("Enter title: ");
                    String title = scnr.nextLine();

                    watchlist.markFinished(title, type);
                }
            }
        

            ListFiles.saveWatchlist(username, type, watchlist.getItems(), watchlist.getCount());
            }
        else {
            System.out.println("Invalid input");
        }
        scnr.close();
    }
}
