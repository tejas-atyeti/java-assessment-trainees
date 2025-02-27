package main.java.util;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE = "logger.log";

    public static void log(String message){
        try(FileWriter fileWriter = new FileWriter(LOG_FILE,true)){

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy:DD:mm HH:mm:ss"));

            fileWriter.write("["+timestamp+"]"+message+"\n");

        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
    }
}
