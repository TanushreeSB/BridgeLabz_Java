import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    // ---------------- CONTACT CLASS ----------------
    static class Contact {
        String firstName, lastName, address, city, state, email;
        int zip;
        String phoneNumber;

        public Contact(String firstName, String lastName, String address,
                       String city, String state, int zip,
                       String phoneNumber, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        @Override
        public String toString() {
            return firstName + " " + lastName + " | " + city + " | " + state + " | " + phoneNumber;
        }

        // UC6 Duplicate Check
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Contact)) return false;
            Contact c = (Contact) obj;
            return firstName.equalsIgnoreCase(c.firstName) &&
                   lastName.equalsIgnoreCase(c.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
        }
    }

    // ---------------- ADDRESS BOOK ----------------
    static class AddressBook {
        List<Contact> contacts = new ArrayList<>();

        // UC1
        void addContact(Contact contact) {
            if (contacts.contains(contact)) {
                System.out.println("Duplicate Contact!");
                return;
            }
            contacts.add(contact);
            System.out.println("Contact Added.");
        }

        // UC2
        void editContact(String name, Scanner sc) {
            for (Contact c : contacts) {
                if (c.firstName.equalsIgnoreCase(name)) {
                    System.out.println("Enter new city:");
                    c.city = sc.nextLine();
                    System.out.println("Updated.");
                    return;
                }
            }
            System.out.println("Contact not found.");
        }

        // UC3
        void deleteContact(String name) {
            boolean removed = contacts.removeIf(c -> c.firstName.equalsIgnoreCase(name));
            System.out.println(removed ? "Deleted." : "Not found.");
        }

        // UC7
        List<Contact> searchByCity(String city) {
            return contacts.stream()
                    .filter(c -> c.city.equalsIgnoreCase(city))
                    .collect(Collectors.toList());
        }

        List<Contact> searchByState(String state) {
            return contacts.stream()
                    .filter(c -> c.state.equalsIgnoreCase(state))
                    .collect(Collectors.toList());
        }

        // UC8
        Map<String, List<Contact>> groupByCity() {
            return contacts.stream().collect(Collectors.groupingBy(c -> c.city));
        }

        Map<String, List<Contact>> groupByState() {
            return contacts.stream().collect(Collectors.groupingBy(c -> c.state));
        }

        // UC9 & UC10
        Map<String, Long> countByCity() {
            return contacts.stream()
                    .collect(Collectors.groupingBy(c -> c.city, Collectors.counting()));
        }

        Map<String, Long> countByState() {
            return contacts.stream()
                    .collect(Collectors.groupingBy(c -> c.state, Collectors.counting()));
        }

        void display() {
            contacts.forEach(System.out::println);
        }
    }

    // ---------------- SYSTEM (UC5) ----------------
    static class AddressBookSystem {
        Map<String, AddressBook> books = new HashMap<>();

        void addBook(String name) {
            books.put(name, new AddressBook());
            System.out.println("AddressBook Created: " + name);
        }

        AddressBook getBook(String name) {
            return books.get(name);
        }

        // UC7 across all
        void searchCityAcross(String city) {
            books.values().stream()
                    .flatMap(b -> b.searchByCity(city).stream())
                    .forEach(System.out::println);
        }
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");

        Scanner sc = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        system.addBook("Default");
        AddressBook book = system.getBook("Default");

        while (true) {
            System.out.println("\n1.Add 2.Edit 3.Delete 4.Display");
            System.out.println("5.Search City 6.Group City 7.Count City 8.Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("First Name:");
                    String fn = sc.nextLine();
                    System.out.println("Last Name:");
                    String ln = sc.nextLine();
                    System.out.println("City:");
                    String city = sc.nextLine();
                    System.out.println("State:");
                    String state = sc.nextLine();

                    Contact c = new Contact(fn, ln, "", city, state, 0, "", "");
                    book.addContact(c);
                    break;

                case 2:
                    System.out.println("Enter name to edit:");
                    book.editContact(sc.nextLine(), sc);
                    break;

                case 3:
                    System.out.println("Enter name to delete:");
                    book.deleteContact(sc.nextLine());
                    break;

                case 4:
                    book.display();
                    break;

                case 5:
                    System.out.println("Enter city:");
                    book.searchByCity(sc.nextLine()).forEach(System.out::println);
                    break;

                case 6:
                    System.out.println(book.groupByCity());
                    break;

                case 7:
                    System.out.println(book.countByCity());
                    break;

                case 8:
                    System.exit(0);
            }
        }
    }
}