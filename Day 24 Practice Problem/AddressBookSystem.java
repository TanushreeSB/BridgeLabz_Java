package BridgeLabz_Java.Day 24 Practice Problem;
import java.util.HashMap;

public class AddressBookSystem {
    
    HashMap<String, AddressBook> bookMap = new HashMap<>();

    public void addAddressBook(String name, AddressBook book) {
        bookMap.put(name, book);
    }

    @Override
    public boolean equals(Object obj) {
        Contact c = (Contact) obj;
        return this.firstName.equals(c.firstName);
    }

    public void searchByCity(String city) {
    contacts.stream()
            .filter(c -> c.city.equals(city))
            .forEach(System.out::println);
    }

    public void viewByCity(String city) {
    contacts.stream()
            .filter(c -> c.city.equals(city))
            .forEach(System.out::println);
    }

  public long countByCity(String city) {
    return contacts.stream()
            .filter(c -> c.city.equals(city))
            .count();
    }
    
    public void sortByName() {
    contacts.stream()
            .sorted((c1, c2) -> c1.firstName.compareTo(c2.firstName))
            .forEach(System.out::println);
    }

    public void sortByCity() {
    contacts.stream()
            .sorted((c1, c2) -> c1.city.compareTo(c2.city))
            .forEach(System.out::println);
    }
}
