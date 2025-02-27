package CSVReader;

import Model.SensorData;
import Model.ThresholdData;
import util.LoggerUtil;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkPermission;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static List<SensorData> readFromSensorData(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.skip(1)
                    .map(String::trim)
                    .map(line -> line.split(","))
                    .filter(parts -> {
                        if (parts.length != 6) {
                            System.out.println("Skipping invalid line " + String.join(",", parts));
                            LoggerUtil.logInfo("Skipping invalid line ");
                            return false;
                        }
                        return true;
                    })
                    .map(parts -> {
                        try {
                            LocalDateTime timestamp = LocalDateTime.parse(parts[0].trim(), DATE_FORMATTER);
                            String sensorType = parts[1].trim();
                            double value = Double.parseDouble(parts[2].trim());
                            String unit = parts[3].trim();
                            int locationId = (int) Double.parseDouble(parts[4].trim());
                            String status = parts[5].trim();

                            return new SensorData(timestamp, sensorType, value, unit, locationId, status);
                        } catch (DateTimeParseException e) {
                            System.out.println("Error parsing date: " + parts[0].trim() + " - " + e.getMessage());
                        LoggerUtil.logInfo("Error parsing date");
                        } catch (NumberFormatException e) {
                            System.out.println("Error parsing numeric values: " + String.join(",", parts) + " - " + e.getMessage());
                        LoggerUtil.logWarning("Error parsing numeric values");
                        }
                        return null;
                    })
                    .filter(data -> data != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error reading sensor data: " + filePath + " - " + e.getMessage());
          LoggerUtil.logWarning("Error reading sensor data");
            return Collections.emptyList();
        }
    }

    public static Map<String, ThresholdData> readFromThresholds(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines.skip(1)
                    .map(line -> line.split(","))
                    .filter(parts -> {
                        if (parts.length != 3) {
                            System.out.println("Skipping invalid threshold line: " + String.join(",", parts));
                            LoggerUtil.logInfo("Skipping invalid");
                            return false;
                        }
                        return true;
                    })
                    .collect(Collectors.toMap(
                            parts -> parts[0].trim(),
                            parts -> {
                                try {
                                    return new ThresholdData(parts[0].trim(),
                                            Double.parseDouble(parts[1].trim()),
                                            Double.parseDouble(parts[2].trim()));
                                } catch (NumberFormatException e) {
                                    System.out.println("Error parsing threshold values: " + String.join(",", parts) + " - " + e.getMessage());
                                  LoggerUtil.logWarning("Error parsing threshold values");
                                    return null;
                                }
                            }
                    ));
        } catch (IOException e) {
            System.out.println("Error reading thresholds: " + filePath + " - " + e.getMessage());
           LoggerUtil.logWarning("Error reading thresholds");
            return Collections.emptyMap();
        }
    }
}
