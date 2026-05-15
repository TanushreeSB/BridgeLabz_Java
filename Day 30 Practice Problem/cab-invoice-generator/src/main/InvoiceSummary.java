public class InvoiceSummary {

    private int numberOfRides;
    private double totalFare;
    private double averageFarePerRide;

    public InvoiceSummary(int numberOfRides,
                          double totalFare) {

        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRide =
                totalFare / numberOfRides;
    }

    @Override
    public String toString() {

        return "Invoice Summary {" +
                "Number Of Rides = " + numberOfRides +
                ", Total Fare = " + totalFare +
                ", Average Fare Per Ride = "
                + averageFarePerRide +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof InvoiceSummary))
            return false;

        InvoiceSummary that =
                (InvoiceSummary) obj;

        return this.numberOfRides == that.numberOfRides
                && this.totalFare == that.totalFare
                && this.averageFarePerRide
                == that.averageFarePerRide;
    }
}