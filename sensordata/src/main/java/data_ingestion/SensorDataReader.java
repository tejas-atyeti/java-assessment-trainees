package main.java.data_ingestion;

import main.java.data_reporting.SensorReportGenerator;
import main.java.exception_handling.SensorDataException;
import main.java.pojo.SensorData;
import main.java.pojo.SensorType;
import main.java.pojo.ThresholdData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SensorDataReader implements DataReader {

    private static final Logger logger = Logger.getLogger(SensorDataReader.class.getName());

    @Override
    public List<?> readData(String path) {
        List<SensorData> sensorData = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        // Read data from CSV file
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            reader.readLine(); // Skip header row if it exists
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) { // Assuming CSV has 3 columns: Name, Age, Email
                    LocalDateTime timestamp = LocalDateTime.parse(fields[0],formatter);
                    SensorType type = SensorType.valueOf(fields[1].toUpperCase());
                    double value = Double.parseDouble(fields[2]);
                    String unit = fields[3];
                    String location = fields[4];

                    SensorData data = new SensorData();
                    sensorData.add(data);
                }
                else{
                    throw new SensorDataException("Invalid number of fields in CSV file");
                }
            }
        } catch(DateTimeParseException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            logger.severe("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.severe("Error parsing number: " + e.getMessage());
        } catch (SensorDataException e) {
            e.printStackTrace();
            logger.severe(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return sensorData;
    }


}
