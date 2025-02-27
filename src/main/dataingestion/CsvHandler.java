package main.dataingestion;

import main.logging.LoggerFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    private static final String SENSOR_FILE_PATH = "src/main/dataingestion/datautils/sensor_data.csv";
    private static final String THRESHOLD_FILE_PATH = "src/main/dataingestion/datautils/thresholds.csv";

    public List<SensorReading> readSensorDataCsv() {
        List<SensorReading> sensorReadings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(SENSOR_FILE_PATH))) {
            String header = br.readLine(); // Read and ignore header
            if (header == null) {
                LoggerFile.logInfo("ERR001: Sensor data file is empty!");
                return sensorReadings;
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length < 5) {
                    LoggerFile.logInfo("ERR002: Invalid data format in line: " + line);
                    continue;
                }

                try {
                    String date = values[0].trim();
                    String sensorType = values[1].trim();
                    double value = values[2].trim().isEmpty() ? 0.0 : Double.parseDouble(values[2].trim());
                    String unit = values[3].trim();
                    double location = values[4].trim().isEmpty() ? 0.0 : Double.parseDouble(values[4].trim());

                    sensorReadings.add(new SensorReading(date, sensorType, value, unit, location));

                } catch (NumberFormatException e) {
                    LoggerFile.logInfo("ERR003: Invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            LoggerFile.logInfo("ERR004: Error reading sensor data - " + e.getMessage());
        }
        LoggerFile.logInfo("Loaded " + sensorReadings.size() + " sensor data records.");
        return sensorReadings;
    }

    public List<Threshold> readThresholdCsv() {
        List<Threshold> thresholds = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(THRESHOLD_FILE_PATH))) {
            String header = br.readLine();
            if (header == null) {
                LoggerFile.logInfo("ERR005: Threshold file is empty!");
                return thresholds;
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");


                if (data.length < 3) {
                    LoggerFile.logInfo("ERR006: Invalid threshold format in line: " + line);
                    continue;
                }

                try {
                    String sensorType = data[0].trim();
                    double minThreshold = data[1].trim().isEmpty() ? 0.0 : Double.parseDouble(data[1].trim());
                    double maxThreshold = data[2].trim().isEmpty() ? 0.0 : Double.parseDouble(data[2].trim());

                    thresholds.add(new Threshold(sensorType, minThreshold, maxThreshold));

                } catch (NumberFormatException e) {
                    LoggerFile.logInfo("ERR007: Invalid number format in threshold line: " + line);
                }
            }
        } catch (IOException e) {
            LoggerFile.logInfo("ERR008: Error reading threshold data - " + e.getMessage());
        }
        LoggerFile.logInfo("Loaded " + thresholds.size() + " threshold records.");
        return thresholds;
    }
}
