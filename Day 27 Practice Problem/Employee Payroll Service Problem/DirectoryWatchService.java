package com.payroll;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class DirectoryWatchService {

    public static void watchDirectory(String pathString)
            throws IOException, InterruptedException {

        Path path = Paths.get(pathString);

        WatchService watchService =
                FileSystems.getDefault().newWatchService();

        path.register(watchService,
                ENTRY_CREATE,
                ENTRY_DELETE,
                ENTRY_MODIFY);

        System.out.println("Watching Directory: " + path);

        while (true) {

            WatchKey key = watchService.take();

            for (WatchEvent<?> event : key.pollEvents()) {

                WatchEvent.Kind<?> kind = event.kind();

                Path fileName = (Path) event.context();

                System.out.println(kind.name() +
                        " : " + fileName);
            }

            boolean valid = key.reset();

            if (!valid) {
                break;
            }
        }
    }
}