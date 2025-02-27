package main.reporting;

import main.dataingestion.SensorReading;
import main.processingService.SensorProcessingService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvWriter {
    public static void writeToCsv(String filePath, List<SensorReading> data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("date,sensor_type,value,unit,location_id,threshold_exceeded\n");
            for (SensorReading line : data) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to CSV file", e);
        }
    }

    public static void writeMonthlyStats(String filePath, Map<String, Map<String, SensorProcessingService.SensorStats>> stats) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("sensor_type,month,avg_value,max_value,min_value\n");
            for (var entry : stats.entrySet()) {
                for (var monthEntry : entry.getValue().entrySet()) {
                    SensorProcessingService.SensorStats statsObj = monthEntry.getValue();
                    writer.write(entry.getKey() + "," + monthEntry.getKey() + "," +
                            statsObj.getAvgValue() + "," + statsObj.getMaxValue() + "," + statsObj.getMinValue() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing monthly stats CSV", e);
        }
    }

}
