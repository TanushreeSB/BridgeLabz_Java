import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class HotelReservation {

    private List<Hotel> hotels = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservation reservationSystem = new HotelReservation();

        reservationSystem.addHotel(
                new Hotel("Lakewood", 3,
                        110, 90,
                        80, 80));

        reservationSystem.addHotel(
                new Hotel("Bridgewood", 4,
                        160, 60,
                        110, 50));

        reservationSystem.addHotel(
                new Hotel("Ridgewood", 5,
                        220, 150,
                        100, 40));

        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12));

        String result = reservationSystem.findCheapestBestRatedHotel(
                dates,
                CustomerType.REWARD);

        System.out.println(result);
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public String findCheapestBestRatedHotel(
            List<LocalDate> dates,
            CustomerType customerType) {

        Hotel cheapestHotel = hotels.stream()
                .min((h1, h2) -> {

                    int rate1 = h1.calculateTotalRate(dates, customerType);
                    int rate2 = h2.calculateTotalRate(dates, customerType);

                    if (rate1 == rate2) {
                        return Integer.compare(h2.getRating(), h1.getRating());
                    }

                    return Integer.compare(rate1, rate2);
                })
                .orElse(null);

        int totalRate =
                cheapestHotel.calculateTotalRate(dates, customerType);

        return cheapestHotel.getName()
                + ", Rating: "
                + cheapestHotel.getRating()
                + " and Total Rates: $"
                + totalRate;
    }

    public String findBestRatedHotel(
            List<LocalDate> dates,
            CustomerType customerType) {

        Hotel bestRated = hotels.stream()
                .max(Comparator.comparing(Hotel::getRating))
                .orElse(null);

        int total =
                bestRated.calculateTotalRate(dates, customerType);

        return bestRated.getName()
                + ", Rating: "
                + bestRated.getRating()
                + " and Total Rates: $"
                + total;
    }

    public static List<LocalDate> validateAndParseDates(
            String input) throws InvalidUserInputException {

        String regex = "\\d{2}[A-Za-z]{3}\\d{4}";
        Pattern pattern = Pattern.compile(regex);

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("ddMMMyyyy", Locale.ENGLISH);

        List<LocalDate> dates = new ArrayList<>();

        String[] tokens = input.split(",");

        for (String token : tokens) {

            token = token.trim();

            if (!pattern.matcher(token).matches()) {
                throw new InvalidUserInputException(
                        "Invalid Date Format: " + token);
            }

            dates.add(LocalDate.parse(token, formatter));
        }

        return dates;
    }
}