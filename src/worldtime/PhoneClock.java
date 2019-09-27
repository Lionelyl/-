package worldtime;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class PhoneClock {
    private int utcOffSet;
    private ZonedDateTime time;
    private HotelLobby hotelLobby;

    PhoneClock(int utcOffSet){
        this.utcOffSet = utcOffSet;
    }

    public void setTime(ZonedDateTime time){
        this.time = time;
        if (hotelLobby == null) return;
        ArrayList<CityClock> cityClocks = hotelLobby.getLobbyClocks();
        for(CityClock cityClock : cityClocks){
            cityClock.setTime((time.minusSeconds(this.utcOffSet*3600)));
        }
    }

    public void setHotelLobby(HotelLobby hotelLobby){
        this.hotelLobby = hotelLobby;
    }

    public ZonedDateTime getTime(){
        return time;
    }
}
