package com.addressbook;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileIOService {

    public static void writeData(List<Contact> contactList,
                                 String fileName) {

        StringBuffer buffer = new StringBuffer();

        contactList.forEach(contact -> {
            String data = contact.toString().concat("\n");
            buffer.append(data);
        });

        try {

            Files.write(Paths.get(fileName),
                    buffer.toString().getBytes());

            System.out.println("Data Written Successfully");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void readData(String fileName) {

        try {

            Files.lines(new File(fileName).toPath())
                    .forEach(System.out::println);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}