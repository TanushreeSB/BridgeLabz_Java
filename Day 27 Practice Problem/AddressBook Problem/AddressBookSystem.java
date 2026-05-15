package com.addressbook;

import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBookMap =
            new HashMap<>();

    public void addAddressBook(String name) {

        addressBookMap.put(name, new AddressBook());

        System.out.println("Address Book Added : " + name);
    }

    public AddressBook getAddressBook(String name) {

        return addressBookMap.get(name);
    }
}