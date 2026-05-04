package model;
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

public abstract class ListItem {
    String title;
    boolean finished;

    public ListItem(String title) {
        this.title = title;
        this.finished = false;
    }

    public String getTitle() {
        return title;
    }

    public void markFinished() {
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }

    public abstract String getType();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ListItem) {
            ListItem other = (ListItem) obj;
            return this.title.equalsIgnoreCase(other.title);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return title.toLowerCase().hashCode();
    }
}
