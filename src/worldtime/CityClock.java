package worldtime;

import java.time.*;

public class CityClock {
    private int utcOffSet;
    private ZonedDateTime time;

    CityClock(int utcOffSet){
        this.utcOffSet = utcOffSet;
    }


    public void setTime(ZonedDateTime time){
        this.time = time.plusSeconds(utcOffSet*3600);
    }

    public ZonedDateTime getTime() {
        return time;
    }
}
