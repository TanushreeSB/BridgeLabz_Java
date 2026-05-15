public class InvoiceService {

    private RideRepository repository;
    private CabInvoiceGenerator generator;

    public InvoiceService() {

        repository = new RideRepository();
        generator = new CabInvoiceGenerator();
    }

    public void addRides(String userId,
                         Ride[] rides) {

        repository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(
            String userId) {

        Ride[] rides =
                repository.getRides(userId);

        return generator.calculateFare(rides);
    }
}