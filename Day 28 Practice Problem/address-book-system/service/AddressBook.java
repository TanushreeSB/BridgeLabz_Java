package model;

import util.SortType;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {

        if (contacts.stream().anyMatch(c -> c.equals(contact))) {
            System.out.println("Duplicate Contact Found!");
            return;
        }

        contacts.add(contact);

        System.out.println("Contact Added Successfully");
    }

    public void editContact(String firstName, Contact updatedContact) {

        for (int i = 0; i < contacts.size(); i++) {

            if (contacts.get(i).getFirstName()
                    .equalsIgnoreCase(firstName)) {

                contacts.set(i, updatedContact);

                System.out.println("Contact Updated");
                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    public void deleteContact(String firstName) {

        boolean removed = contacts.removeIf(
                contact -> contact.getFirstName()
                        .equalsIgnoreCase(firstName));

        if (removed)
            System.out.println("Contact Deleted");
        else
            System.out.println("Contact Not Found");
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void displayContacts() {
        contacts.forEach(System.out::println);
    }

    public void sortContacts(SortType sortType) {

        Comparator<Contact> comparator;

        switch (sortType) {

            case CITY:
                comparator = Comparator.comparing(Contact::getCity);
                break;

            case STATE:
                comparator = Comparator.comparing(Contact::getState);
                break;

            case ZIP:
                comparator = Comparator.comparing(Contact::getZip);
                break;

            default:
                comparator = Comparator.comparing(Contact::getFirstName);
        }

        contacts = contacts.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}