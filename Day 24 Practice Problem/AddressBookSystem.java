package BridgeLabz_Java.Day 24 Practice Problem;
import java.util.HashMap;

public class AddressBookSystem {
    
    HashMap<String, AddressBook> bookMap = new HashMap<>();

    public void addAddressBook(String name, AddressBook book) {
        bookMap.put(name, book);
    }

}
