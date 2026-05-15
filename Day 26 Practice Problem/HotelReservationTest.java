import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HotelReservationTest {

    private HotelReservation reservationSystem;

    @BeforeEach
    void setUp() {

        reservationSystem = new HotelReservation();

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
    }

    @Test
    void shouldReturnCheapestBestRatedHotelForRewardCustomer() {

        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2020, 9, 11),
                LocalDate.of(2020, 9, 12));

        String result =
                reservationSystem.findCheapestBestRatedHotel(
                        dates,
                        CustomerType.REWARD);

        assertEquals(
                "Ridgewood, Rating: 5 and Total Rates: $140",
                result);
    }

    @Test
    void shouldReturnCheapestHotelForRegularCustomer() {

        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2020, 9, 10),
                LocalDate.of(2020, 9, 11));

        String result =
                reservationSystem.findCheapestBestRatedHotel(
                        dates,
                        CustomerType.REGULAR);

        assertEquals(
                "Lakewood, Rating: 3 and Total Rates: $220",
                result);
    }
}