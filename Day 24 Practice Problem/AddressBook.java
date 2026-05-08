package BridgeLabz_Java.Day 24 Practice Problem;

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void editContact(String firstName, String newCity) {
    for (Contact c : contacts) {
        if (c.firstName.equals(firstName)) {
            c.city = newCity;}
        }
    }

    
}
