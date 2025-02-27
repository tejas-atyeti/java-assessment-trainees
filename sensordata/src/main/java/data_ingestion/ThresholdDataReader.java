package main.java.data_ingestion;

import main.java.data_reporting.SensorReportGenerator;
import main.java.exception_handling.SensorDataException;
import main.java.pojo.SensorType;
import main.java.pojo.ThresholdData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ThresholdDataReader implements DataReader {

    private static final Logger logger = Logger.getLogger(ThresholdDataReader.class.getName());

    @Override
    public List<?> readData(String path) {
        List<ThresholdData> thresholdData = new ArrayList<>();
        // Read data from CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            reader.readLine(); // Skip header row if it exists
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) { // Assuming CSV has 3 columns: Name, Age, Email
                    SensorType type = SensorType.valueOf(fields[0].toUpperCase());
                    double minThreshold = Double.parseDouble(fields[1]);
                    double maxThreshold = Double.parseDouble(fields[2]);

                    ThresholdData data = new ThresholdData();
                    thresholdData.add(data);
                }
                else{
                    throw new SensorDataException("Invalid number of fields in CSV file");
                }
            }
        } catch (IOException e) {
            logger.severe("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            logger.severe("Error parsing number: " + e.getMessage());
        } catch (SensorDataException e) {
            logger.severe(e.getMessage());
        }
        return thresholdData;
    }
}
