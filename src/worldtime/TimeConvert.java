package worldtime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeConvert {
    public static ZonedDateTime convertStringToDateTime(String dateTimeString) {
        ZonedDateTime time;
        try {

            String[] parts = dateTimeString.split(":", 2);
            int year = ZonedDateTime.now().getYear();
            int month = ZonedDateTime.now().getMonthValue();
            int day = ZonedDateTime.now().getDayOfMonth();
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            int second = 0;
            int ms = 0;
            time = ZonedDateTime.of(year, month, day, hour, minute, second, ms, ZoneId.of("Asia/Shanghai"));
        } catch (Throwable exception) {
            throw new RuntimeException("输入预约时间格式不正确 ["
                    + dateTimeString + "]， 输入格式为[HH:mm]");
        }
        return time;
    }
}