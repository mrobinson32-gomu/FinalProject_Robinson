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
public class TvShow extends ListItem {
    public TvShow(String title) {
        super(title);
    }

    @Override
    public String getType() {
        return "TV Show";
    }
}

