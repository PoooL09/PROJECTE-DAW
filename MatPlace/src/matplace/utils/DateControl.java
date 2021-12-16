package matplace.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateControl {

    public LocalDateTime datePlusTime (String date, String time) {

        String dateTime = date + " " + time;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, formatter);

        return localDateTime;
    }



}
