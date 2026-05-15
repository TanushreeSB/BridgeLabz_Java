package service;

import com.opencsv.CSVWriter;
import model.Contact;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVService {

    public static void writeContactsToCSV(
            String fileName,
            List<Contact> contacts) throws IOException {

        CSVWriter writer = new CSVWriter(
                new FileWriter(fileName));

        String[] header = {
                "FirstName", "LastName", "City"
        };

        writer.writeNext(header);

        for (Contact contact : contacts) {

            String[] data = {
                    contact.getFirstName(),
                    contact.getState(),
                    contact.getCity()
            };

            writer.writeNext(data);
        }

        writer.close();

        System.out.println("CSV File Written");
    }
}