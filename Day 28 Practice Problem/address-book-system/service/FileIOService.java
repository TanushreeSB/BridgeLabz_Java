package service;

import model.Contact;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileIOService {

    public static void writeToFile(
            String fileName,
            List<Contact> contacts) throws IOException {

        FileWriter writer = new FileWriter(fileName);

        for (Contact contact : contacts) {

            writer.write(contact.toString());
            writer.write("\n\n");
        }

        writer.close();

        System.out.println("Data Written To File");
    }
}