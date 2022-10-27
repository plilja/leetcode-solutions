import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse(date2, DateTimeFormatter.ISO_LOCAL_DATE);
        return Math.abs((int)ChronoUnit.DAYS.between(d1, d2));
    }
}