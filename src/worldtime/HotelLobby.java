package worldtime;

import java.util.ArrayList;

public class HotelLobby {
    private ArrayList<CityClock> lobbyClocks = new ArrayList<CityClock>();

    public void addClocks(CityClock cityClock){
        lobbyClocks.add(cityClock);
    }

    public ArrayList<CityClock> getLobbyClocks() {
        return lobbyClocks;
    }

}
