package BridgeLabz_Java.Day 24 Practice Problem;

public class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    String email;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phone, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + city;
    }
}
