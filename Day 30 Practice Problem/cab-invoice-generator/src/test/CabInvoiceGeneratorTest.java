import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {

    CabInvoiceGenerator generator =
            new CabInvoiceGenerator();

    // UC1
    @Test
    public void givenDistanceAndTime_ShouldReturnFare() {

        Ride ride =
                new Ride(2.0, 5,
                        RideCategory.NORMAL);

        double fare =
                generator.calculateFare(ride);

        Assertions.assertEquals(25, fare);
    }

    // UC2
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {

        Ride[] rides = {
                new Ride(2.0, 5,
                        RideCategory.NORMAL),

                new Ride(3.0, 10,
                        RideCategory.NORMAL)
        };

        InvoiceSummary summary =
                generator.calculateFare(rides);

        InvoiceSummary expected =
                new InvoiceSummary(2, 65);

        Assertions.assertEquals(expected, summary);
    }

    // UC4
    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {

        InvoiceService service =
                new InvoiceService();

        Ride[] rides = {
                new Ride(2.0, 5,
                        RideCategory.NORMAL),

                new Ride(3.0, 10,
                        RideCategory.NORMAL)
        };

        service.addRides("user1", rides);

        InvoiceSummary summary =
                service.getInvoiceSummary("user1");

        InvoiceSummary expected =
                new InvoiceSummary(2, 65);

        Assertions.assertEquals(expected, summary);
    }

    // UC5
    @Test
    public void givenPremiumRide_ShouldReturnFare() {

        Ride ride =
                new Ride(2.0, 5,
                        RideCategory.PREMIUM);

        double fare =
                generator.calculateFare(ride);

        Assertions.assertEquals(40, fare);
    }
}