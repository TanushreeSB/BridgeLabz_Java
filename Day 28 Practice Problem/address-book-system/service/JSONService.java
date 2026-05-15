package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Contact;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONService {

    public static void writeToJson(
            String fileName,
            List<Contact> contacts) throws IOException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileWriter writer = new FileWriter(fileName);

        gson.toJson(contacts, writer);

        writer.close();

        System.out.println("JSON File Written");
    }
}