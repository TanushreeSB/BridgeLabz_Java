import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Hotel {

    private String name;
    private int rating;

    private int regularWeekdayRate;
    private int regularWeekendRate;

    private int rewardWeekdayRate;
    private int rewardWeekendRate;

    public Hotel(String name, int rating,
                 int regularWeekdayRate,
                 int regularWeekendRate,
                 int rewardWeekdayRate,
                 int rewardWeekendRate) {

        this.name = name;
        this.rating = rating;

        this.regularWeekdayRate = regularWeekdayRate;
        this.regularWeekendRate = regularWeekendRate;

        this.rewardWeekdayRate = rewardWeekdayRate;
        this.rewardWeekendRate = rewardWeekendRate;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int calculateTotalRate(List<LocalDate> dates, CustomerType customerType) {

        int total = 0;

        for (LocalDate date : dates) {

            boolean isWeekend =
                    date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    date.getDayOfWeek() == DayOfWeek.SUNDAY;

            if (customerType == CustomerType.REGULAR) {
                total += isWeekend ? regularWeekendRate : regularWeekdayRate;
            } else {
                total += isWeekend ? rewardWeekendRate : rewardWeekdayRate;
            }
        }

        return total;
    }

    @Override
    public String toString() {
        return name + ", Rating: " + rating;
    }
}