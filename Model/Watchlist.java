package model;

import util.ListFiles;

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
public class Watchlist {
    private ListItem[] items;
    private int count;
    private String username;

    public Watchlist(String username) {
        this.username = username;
        this.items = new ListItem[100];
        this.count = 0;
    }

    public Watchlist(String username, ListItem[] loadedItems) {
        this.username = username;
        this.items = new ListItem[100];
        this.count = 0;

        for (ListItem item : loadedItems) {
            if (item != null && count < items.length) {
                items[count++] = item;
            }
        }
    }

    public void additem(ListItem item) {
        if (item == null) {
            System.out.println("Invalid item");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (items[i].equals(item)) {
                System.out.println("Item already exists");
                return;
            }
        }

        if (count < items.length) {
            items [count++] = item;
        }
        else {
            System.out.println("Watchlist is full");
        }
    }

    public void display() {
        if (count == 0) {
            System.out.println("No watchlist exist yet");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void markfinished(String title, String type) {
        if (title == null || title.isEmpty()) {
            System.out.println("Invalid title");
            return;
        }

        boolean found = false; for (int i = 0; i < count; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title)) {

                items[i].markFinished();

                ListFiles.saveFinished(username, type, items[i]);

                for (int j = i; j < count -1; j++) {
                    items[j] = items[j + 1];
                }

                items[count - 1] = null;
                count--;

                System.out.println(title + " marked as finished");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found");
        }
    }

    public ListItem[] getitems() {
        return items;
    }

    public int getCount() {
        return count;
    }


}
