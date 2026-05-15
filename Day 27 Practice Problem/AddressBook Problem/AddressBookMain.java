package com.addressbook;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        AddressBookSystem system = new AddressBookSystem();

        // UC6 Add Multiple Address Books
        system.addAddressBook("Friends");
        system.addAddressBook("Family");

        AddressBook friendsBook =
                system.getAddressBook("Friends");

        // UC2 Add Contact
        friendsBook.addContact();

        // UC5 Display Contacts
        friendsBook.displayContacts();

        // UC10 Sort By Name
        friendsBook.sortByName();

        // UC12 Write To File
        FileIOService.writeData(
                friendsBook.getContactList(),
                "addressbook.txt");

        // UC12 Read From File
        FileIOService.readData("addressbook.txt");
    }
}