package BridgeLabz_Java;

public class AddressBookMain {
     public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        AddressBook book = new AddressBook();

        Contact c1 = new Contact("Tanu", "Sharma", "Chennai",
                "Chennai", "TN", "600001",
                "9999999999", "tanu@gmail.com");

        book.addContact(c1);

        System.out.println(c1);
    }
}
