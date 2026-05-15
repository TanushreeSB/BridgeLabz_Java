import model.AddressBook;
import model.Contact;
import service.AddressBookSystem;
import util.SortType;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println(
                "Welcome to Address Book Program");

        AddressBookSystem system =
                new AddressBookSystem();

        system.addAddressBook("Friends");

        AddressBook addressBook =
                system.getAddressBook("Friends");

        Contact person1 = new Contact(
                "John",
                "Doe",
                "Street 1",
                "Chennai",
                "Tamil Nadu",
                "600001",
                "9876543210",
                "john@gmail.com"
        );

        Contact person2 = new Contact(
                "Alice",
                "Smith",
                "Street 2",
                "Bangalore",
                "Karnataka",
                "560001",
                "9876543211",
                "alice@gmail.com"
        );

        addressBook.addContact(person1);
        addressBook.addContact(person2);

        addressBook.displayContacts();

        addressBook.sortContacts(SortType.NAME);

        System.out.println("\nSorted Contacts:");
        addressBook.displayContacts();
    }
}