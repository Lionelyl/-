package worldtime;

import sun.lwawt.macosx.CImage;

import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelTimeUI {
    public static void main(String[] args) {
        //init
        PhoneClock phoneClock = new PhoneClock(8);
        HotelLobby hotelLobby = new HotelLobby();

        CityClock londonClock = new CityClock(0);
        CityClock beijingClock = new CityClock(8);
        CityClock moscowClock = new CityClock(4);
        CityClock sydneyClock = new CityClock(10);
        CityClock new_yorkColck = new CityClock(-5);

        hotelLobby.addClocks(londonClock);
        hotelLobby.addClocks(beijingClock);
        hotelLobby.addClocks(moscowClock);
        hotelLobby.addClocks(sydneyClock);
        hotelLobby.addClocks(new_yorkColck);

        System.out.println("Please set the time of Phone: (HH:mm)");
        Scanner scanner = new Scanner(System.in);

        String timeString = scanner.next();
        /*String[] parts = timeString.split(":",2);
        ZonedDateTime time;
        int year = ZonedDateTime.now().getYear();
        int month = ZonedDateTime.now().getMonthValue();
        int day = ZonedDateTime.now().getDayOfMonth();
        int hour = Integer.parseInt(parts[0]);
        int minute =Integer.parseInt(parts[1]);
        int second = 0;
        int ms = 0;

        time = ZonedDateTime.of(year,month,day,hour,minute,second,ms, ZoneId.of("Asia/Shanghai"));*/
        ZonedDateTime time = TimeConvert.convertStringToDateTime(timeString);
        phoneClock.setHotelLobby(hotelLobby);
        phoneClock.setTime(time);

        System.out.println("PhoneClock:    "+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(time));
        ArrayList<CityClock> cityClocks = hotelLobby.getLobbyClocks();
        System.out.println("LondonClcok:   "+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(cityClocks.get(0).getTime()));
        System.out.println("BeijingClcok:  "+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(cityClocks.get(1).getTime()));
        System.out.println("MoscowClcok:   "+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(cityClocks.get(2).getTime()));
        System.out.println("SydneyClcok:   "+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(cityClocks.get(3).getTime()));
        System.out.println("NewYorkClcok:  "+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(cityClocks.get(4).getTime()));


    }
}
