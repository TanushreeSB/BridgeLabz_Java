public class Ride {

    double distance;
    int time;
    RideCategory category;

    public Ride(double distance,
                int time,
                RideCategory category) {

        this.distance = distance;
        this.time = time;
        this.category = category;
    }
}