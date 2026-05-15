package com.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private List<Contact> contactList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    // UC2 Add Contact
    public void addContact() {

        System.out.println("Enter First Name:");
        String firstName = scanner.next();

        System.out.println("Enter Last Name:");
        String lastName = scanner.next();

        // UC7 Duplicate Validation
        boolean duplicate = contactList.stream()
                .anyMatch(person ->
                        person.getFirstName().equalsIgnoreCase(firstName));

        if (duplicate) {
            System.out.println("Duplicate Contact Found!");
            return;
        }

        System.out.println("Enter Address:");
        String address = scanner.next();

        System.out.println("Enter City:");
        String city = scanner.next();

        System.out.println("Enter State:");
        String state = scanner.next();

        System.out.println("Enter Zip:");
        String zip = scanner.next();

        System.out.println("Enter Phone Number:");
        String phone = scanner.next();

        System.out.println("Enter Email:");
        String email = scanner.next();

        Contact person = new Contact(firstName, lastName,
                address, city, state, zip, phone, email);

        contactList.add(person);

        System.out.println("Contact Added Successfully");
    }

    // UC3 Edit Contact
    public void editContact(String firstName) {

        for (Contact person : contactList) {

            if (person.getFirstName().equalsIgnoreCase(firstName)) {

                System.out.println("Contact Found");
                System.out.println("Editing feature can be added here");

                return;
            }
        }

        System.out.println("Contact Not Found");
    }

    // UC4 Delete Contact
    public void deleteContact(String firstName) {

        contactList.removeIf(person ->
                person.getFirstName()
                        .equalsIgnoreCase(firstName));

        System.out.println("Contact Deleted");
    }

    // UC5 Display Multiple Contacts
    public void displayContacts() {

        contactList.forEach(System.out::println);
    }

    // UC8 Search By City
    public void searchByCity(String city) {

        List<Contact> result = contactList.stream()
                .filter(person ->
                        person.getCity()
                                .equalsIgnoreCase(city))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    // UC8 Search By State
    public void searchByState(String state) {

        List<Contact> result = contactList.stream()
                .filter(person ->
                        person.getState()
                                .equalsIgnoreCase(state))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    // UC9 Count By City
    public long countByCity(String city) {

        return contactList.stream()
                .filter(person ->
                        person.getCity()
                                .equalsIgnoreCase(city))
                .count();
    }

    // UC9 Count By State
    public long countByState(String state) {

        return contactList.stream()
                .filter(person ->
                        person.getState()
                                .equalsIgnoreCase(state))
                .count();
    }

    // UC10 Sort By Name
    public void sortByName() {

        contactList.stream()
                .sorted(Comparator.comparing(Contact::getFirstName))
                .forEach(System.out::println);
    }

    // UC11 Sort By City
    public void sortByCity() {

        contactList.stream()
                .sorted(Comparator.comparing(Contact::getCity))
                .forEach(System.out::println);
    }

    // UC11 Sort By State
    public void sortByState() {

        contactList.stream()
                .sorted(Comparator.comparing(Contact::getState))
                .forEach(System.out::println);
    }

    // UC11 Sort By Zip
    public void sortByZip() {

        contactList.stream()
                .sorted(Comparator.comparing(Contact::getZip))
                .forEach(System.out::println);
    }

    public List<Contact> getContactList() {
        return contactList;
    }
}