import java.time.*;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        switch (LocalDate.of(year, month, day).getDayOfWeek().getValue()) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                throw new IllegalStateException("Unable to determine weekday");
        }
    }
}
