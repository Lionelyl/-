package worldtime;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CityClockTest {

    @Test
    void the_time_of_city_should_be_setTime_plus_utcOffSet() {

        CityClock cityClock = new CityClock(8);
        cityClock.setTime(ZonedDateTime.of(2019,11,11,00,00,00,00, ZoneId.of("Asia/Shanghai")));

        ZonedDateTime time = ZonedDateTime.of(2019,11,11,8,00,00,00, ZoneId.of("Asia/Shanghai"));

        assertEquals(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(time),
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(cityClock.getTime()));
    }
}