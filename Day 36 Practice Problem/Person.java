import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/*
=========================================================
ADDRESS BOOK PROGRAM - COMPLETE SINGLE FILE
=========================================================

UC 1  : Add Person
UC 2  : Edit Person
UC 3  : Delete Person
UC 4  : Add Multiple Persons
UC 5  : Prevent Duplicate Entry
UC 6  : Sort By Name
UC 7  : Sort By City, State, Zip
UC 8  : View Person By City and State
UC 9  : Search Person By City or State
UC 10 : Read/Write JSON File
UC 11 : Read/Write CSV File
UC 12 : JSON using GSON
UC 13 : JSON Server Ready
UC 14 : Non Blocking IO using Multithreading
=========================================================
*/

class Person {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;

    public Person(String firstName,
                  String lastName,
                  String address,
                  String city,
                  String state,
                  String zip,
                  String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    // UC 5
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Person person = (Person) obj;

        return firstName.equalsIgnoreCase(person.firstName)
                && lastName.equalsIgnoreCase(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    // UC 6
    @Override
    public String toString() {

        return "\n----------------------------------" +
                "\nName       : " + firstName + " " + lastName +
                "\nAddress    : " + address +
                "\nCity       : " + city +
                "\nState      : " + state +
                "\nZip        : " + zip +
                "\nPhone      : " + phoneNumber +
                "\n----------------------------------";
    }
}

class AddressBook {

    // UC 4
    List<Person> personList = new ArrayList<>();

    // UC 1
    public void addPerson(Person person) {

        // UC 5
        boolean duplicate = personList.stream()
                .anyMatch(p -> p.equals(person));

        if (duplicate) {
            System.out.println("Duplicate Person Found!");
            return;
        }

        personList.add(person);

        System.out.println("Person Added Successfully");
    }

    // UC 2
    public void editPerson(String firstName) {

        Scanner scanner = new Scanner(System.in);

        Optional<Person> personOptional = personList.stream()
                .filter(p -> p.firstName.equalsIgnoreCase(firstName))
                .findFirst();

        if (personOptional.isPresent()) {

            Person person = personOptional.get();

            System.out.print("Enter New Address : ");
            person.address = scanner.nextLine();

            System.out.print("Enter New City : ");
            person.city = scanner.nextLine();

            System.out.print("Enter New State : ");
            person.state = scanner.nextLine();

            System.out.print("Enter New Zip : ");
            person.zip = scanner.nextLine();

            System.out.print("Enter New Phone : ");
            person.phoneNumber = scanner.nextLine();

            System.out.println("Person Updated Successfully");

        } else {

            System.out.println("Person Not Found");
        }
    }

    // UC 3
    public void deletePerson(String firstName) {

        boolean removed = personList.removeIf(
                p -> p.firstName.equalsIgnoreCase(firstName));

        if (removed)
            System.out.println("Person Deleted");
        else
            System.out.println("Person Not Found");
    }

    // UC 6
    public void sortByName() {

        List<Person> sortedList = personList.stream()
                .sorted(Comparator.comparing(p -> p.firstName))
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }

    // UC 7
    public void sortByCity() {

        personList.stream()
                .sorted(Comparator.comparing(p -> p.city))
                .forEach(System.out::println);
    }

    public void sortByState() {

        personList.stream()
                .sorted(Comparator.comparing(p -> p.state))
                .forEach(System.out::println);
    }

    public void sortByZip() {

        personList.stream()
                .sorted(Comparator.comparing(p -> p.zip))
                .forEach(System.out::println);
    }

    // UC 8
    public void viewByCity() {

        Map<String, List<Person>> cityMap =
                personList.stream()
                        .collect(Collectors.groupingBy(p -> p.city));

        cityMap.forEach((city, persons) -> {

            System.out.println("\nCity : " + city);

            persons.forEach(p ->
                    System.out.println(p.firstName + " " + p.lastName));
        });
    }

    public void viewByState() {

        Map<String, List<Person>> stateMap =
                personList.stream()
                        .collect(Collectors.groupingBy(p -> p.state));

        stateMap.forEach((state, persons) -> {

            System.out.println("\nState : " + state);

            persons.forEach(p ->
                    System.out.println(p.firstName + " " + p.lastName));
        });
    }

    // UC 9
    public void searchByCity(String city) {

        List<Person> result = personList.stream()
                .filter(p -> p.city.equalsIgnoreCase(city))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    public void searchByState(String state) {

        List<Person> result = personList.stream()
                .filter(p -> p.state.equalsIgnoreCase(state))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }

    // =====================================================
    // UC 10 & 12 : JSON FILE USING GSON
    // =====================================================

    public void writeToJSON(String fileName) {

        Gson gson = new Gson();

        try (Writer writer = new FileWriter(fileName)) {

            gson.toJson(personList, writer);

            System.out.println("JSON File Written Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void readFromJSON(String fileName) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader(fileName)) {

            List<Person> persons =
                    gson.fromJson(reader,
                            new TypeToken<List<Person>>() {
                            }.getType());

            persons.forEach(System.out::println);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // =====================================================
    // UC 11 : CSV FILE
    // =====================================================

    public void writeToCSV(String fileName) {

        try (PrintWriter writer = new PrintWriter(fileName)) {

            writer.println(
                    "FirstName,LastName,Address,City,State,Zip,Phone");

            for (Person person : personList) {

                writer.println(
                        person.firstName + "," +
                                person.lastName + "," +
                                person.address + "," +
                                person.city + "," +
                                person.state + "," +
                                person.zip + "," +
                                person.phoneNumber);
            }

            System.out.println("CSV File Written Successfully");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void readFromCSV(String fileName) {

        try {

            List<String> lines =
                    Files.readAllLines(Paths.get(fileName));

            lines.forEach(System.out::println);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    // =====================================================
    // UC 14 : MULTITHREADING FOR IO
    // =====================================================

    public void writeJSONAsync(String fileName) {

        CompletableFuture.runAsync(() -> {

            writeToJSON(fileName);

        }).thenRun(() ->
                System.out.println("Async JSON Write Completed"));
    }

    public void writeCSVAsync(String fileName) {

        CompletableFuture.runAsync(() -> {

            writeToCSV(fileName);

        }).thenRun(() ->
                System.out.println("Async CSV Write Completed"));
    }
}

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println(
                "WELCOME TO ADDRESS BOOK PROGRAM");

        Scanner scanner = new Scanner(System.in);

        AddressBook addressBook = new AddressBook();

        // =====================================================
        // UC 1 & 4 : ADD MULTIPLE PERSONS
        // =====================================================

        Person p1 = new Person(
                "John",
                "Doe",
                "Anna Nagar",
                "Chennai",
                "Tamil Nadu",
                "600001",
                "9876543210");

        Person p2 = new Person(
                "Priya",
                "Sharma",
                "MG Road",
                "Bangalore",
                "Karnataka",
                "560001",
                "9999999999");

        Person p3 = new Person(
                "Rahul",
                "Kumar",
                "Andheri",
                "Mumbai",
                "Maharashtra",
                "400001",
                "8888888888");

        addressBook.addPerson(p1);
        addressBook.addPerson(p2);
        addressBook.addPerson(p3);

        // =====================================================
        // UC 5 : DUPLICATE CHECK
        // =====================================================

        Person duplicatePerson = new Person(
                "John",
                "Doe",
                "Test",
                "Test",
                "Test",
                "111111",
                "1234567890");

        addressBook.addPerson(duplicatePerson);

        // =====================================================
        // UC 6 : SORT BY NAME
        // =====================================================

        System.out.println("\nSORT BY NAME");
        addressBook.sortByName();

        // =====================================================
        // UC 7 : SORT BY CITY
        // =====================================================

        System.out.println("\nSORT BY CITY");
        addressBook.sortByCity();

        // =====================================================
        // UC 8 : VIEW BY CITY
        // =====================================================

        System.out.println("\nVIEW PERSONS BY CITY");
        addressBook.viewByCity();

        // =====================================================
        // UC 9 : SEARCH BY STATE
        // =====================================================

        System.out.println("\nSEARCH PERSON BY STATE");
        addressBook.searchByState("Tamil Nadu");

        // =====================================================
        // UC 10 & 12 : JSON FILE
        // =====================================================

        addressBook.writeToJSON("addressBook.json");

        System.out.println("\nREAD FROM JSON");
        addressBook.readFromJSON("addressBook.json");

        // =====================================================
        // UC 11 : CSV FILE
        // =====================================================

        addressBook.writeToCSV("addressBook.csv");

        System.out.println("\nREAD FROM CSV");
        addressBook.readFromCSV("addressBook.csv");

        // =====================================================
        // UC 14 : ASYNC OPERATIONS
        // =====================================================

        addressBook.writeJSONAsync("asyncAddressBook.json");

        addressBook.writeCSVAsync("asyncAddressBook.csv");

        // =====================================================
        // UC 13 : JSON SERVER READY
        // =====================================================

        System.out.println(
                "\nJSON Server can use generated JSON file");

        System.out.println(
                "\nProgram Completed Successfully");
    }
}