package worldtime;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TimeConvertTest {

    @Test
    void valid_Input_test_convertStringToDateTime() {
        String dateTimeString ="08:00";
        assertEquals( "08:00", DateTimeFormatter.ofPattern("HH:mm").format(TimeConvert.convertStringToDateTime("08:00")));
    }

    @Test
    void invalid_input_test_concerStringToDateTime() {
        Throwable ecxeption = assertThrows(RuntimeException.class,()->TimeConvert.convertStringToDateTime("12 o'clock"));
        assertEquals("输入预约时间格式不正确 [12 o'clock]， 输入格式为[HH:mm]",ecxeption.getMessage());
    }
}