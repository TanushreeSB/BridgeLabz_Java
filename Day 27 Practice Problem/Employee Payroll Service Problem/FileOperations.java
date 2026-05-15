package com.payroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileOperations {

    public static void performOperations() {

        try {

            // Create Directory
            Path dirPath = Paths.get("PayrollDirectory");

            if (!Files.exists(dirPath)) {
                Files.createDirectory(dirPath);
                System.out.println("Directory Created");
            }

            // Create Empty File
            Path filePath = Paths.get("PayrollDirectory/sample.txt");

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
                System.out.println("File Created");
            }

            // Check File Exists
            System.out.println("File Exists : " +
                    Files.exists(filePath));

            // List Files and Directories
            Files.list(dirPath)
                    .forEach(System.out::println);

            // Delete File
            Files.deleteIfExists(filePath);

            // Check File Not Exists
            System.out.println("File Exists After Delete : " +
                    Files.exists(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}