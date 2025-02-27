package util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
    private static final Logger logger=Logger.getLogger(LoggerUtil.class.getName());

    static {
        try{
            FileHandler fileHandler=new FileHandler("C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\CoreJavaAssesment\\java-assessment-trainees\\csv-extraction\\src\\main\\java\\Logs\\Application.log",true);
            fileHandler.setFormatter(new SimpleFormatter());

            // set log levels
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        }catch (IOException e){
            System.err.println("Failed to initialize loggger:"+e.getMessage());
        }
    }
    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarning(String message) {
        logger.warning(message);
    }

    public static void logSevere(String message) {
        logger.severe(message);
    }
}
