package main.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerFile {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());


    static{
        try{
            FileHandler fileHandler= new FileHandler("C:\\Users\\ShubhamPalkar\\OneDrive - Atyeti Inc\\Documents\\Java_Assesment\\java-assessment-trainees\\src\\main\\logging\\Logs.log");
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logInfo(String message){
        logger.info(message);
    }

    public static void logWarn(String message){
        logger.warning(message);
    }
}
