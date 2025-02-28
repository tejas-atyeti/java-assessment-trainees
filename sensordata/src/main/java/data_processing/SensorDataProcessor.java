package main.java.data_processing;

import main.java.pojo.SensorData;
import main.java.pojo.SensorReport;
import main.java.pojo.SensorType;
import main.java.pojo.ThresholdData;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SensorDataProcessor {

    private static final Logger logger = Logger.getLogger(SensorDataProcessor.class.getName());

    public List<SensorReport> processData(List<SensorData> sensorData, List<ThresholdData> thresholdData) {

        List<SensorReport> sensorReports = new ArrayList<>();

        List<SensorType> sensorTypes = thresholdData.stream().map(ThresholdData::getType).toList();

        try {
            // Grouping data by sensor type and month
            for (SensorType sensorType : sensorTypes) {
                sensorData.stream()
                        .filter(data -> data.getType() != null && data.getType().equals(sensorType))
                        .collect(Collectors.groupingBy(data -> data.getTimestamp().getMonth()))
                        .forEach((month, data) -> {
                            logger.info("Processing data for sensor type: " + sensorType + " and month: " + month);
                            double average = data.stream().mapToDouble(SensorData::getValue).average().orElse(0);
                            double max = data.stream().mapToDouble(SensorData::getValue).max().orElse(0);
                            double min = data.stream().mapToDouble(SensorData::getValue).min().orElse(0);
                            sensorReports.add(new SensorReport(sensorType, month.toString(), average, max, min));
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Error processing sensor data: " + e.getMessage());
        }
        return sensorReports;
    }
}
