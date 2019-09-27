package worldtime;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class PhoneClockTest {
    private HotelLobby hotelLobby;
    private PhoneClock phone;

    PhoneClockTest() {
        phone = new PhoneClock(8);
        hotelLobby = new HotelLobby();
    }

    @Test
    void the_time_of_phone_should_be_the_same_with_the_time_be_setted() {
        phone.setTime(ZonedDateTime.now());

        assertEquals(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(ZonedDateTime.now()),
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(phone.getTime()));
    }

    @Test
    void the_time_of_clock_London_should_be_phone_clock_minus_7() {
        CityClock londonClock = new CityClock(1);
        hotelLobby.addClocks(londonClock);

        phone.setHotelLobby(hotelLobby);
        phone.setTime(ZonedDateTime.now());

        ZonedDateTime londonTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/London"));
        assertEquals(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(londonTime),
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(londonClock.getTime()));
    }

    @Test
    void the_time_of_clock_Beijing_should_be_the_phone_clock_plus_0() {
        CityClock beijingClock = new CityClock(8);
        hotelLobby.addClocks(beijingClock);

        phone.setHotelLobby(hotelLobby);
        phone.setTime(ZonedDateTime.now());

        ZonedDateTime londonTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        assertEquals(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(londonTime),
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(beijingClock.getTime()));
    }

    @Test
    void the_time_of_clock_Moscow_should_be_the_phone_clock_minus_5() {
        CityClock moscowClock = new CityClock(3);
        hotelLobby.addClocks(moscowClock);

        phone.setHotelLobby(hotelLobby);
        phone.setTime(ZonedDateTime.now());

        ZonedDateTime londonTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/Moscow"));
        assertEquals(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(londonTime),
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(moscowClock.getTime()));
    }

    @Test
    void the_time_of_clock_Sydney_should_be_the_phone_clock_plus_2() {
        CityClock sydneyClock = new CityClock(10);
        hotelLobby.addClocks(sydneyClock);

        phone.setHotelLobby(hotelLobby);
        phone.setTime(ZonedDateTime.now());

        ZonedDateTime londonTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Australia/Sydney"));
        assertEquals(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(londonTime),
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(sydneyClock.getTime()));
    }

    @Test
    void the_time_of_clock_Now_York_should_be_the_phone_clock_minus_12() {
        CityClock newyorkClock = new CityClock(-4);
        hotelLobby.addClocks(newyorkClock);

        phone.setHotelLobby(hotelLobby);
        phone.setTime(ZonedDateTime.now());

        ZonedDateTime londonTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("America/New_York"));
        assertEquals(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(londonTime),
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(newyorkClock.getTime()));
    }
}