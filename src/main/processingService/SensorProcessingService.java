package main.processingService;

import main.dataingestion.SensorReading;
import main.logging.LoggerFile;

import java.util.*;
import java.util.stream.Collectors;

public class SensorProcessingService {

    public static class SensorStats {
        private final double avgValue;
        private final double maxValue;
        private final double minValue;

        public SensorStats(double avg, double max, double min) {
            this.avgValue = avg;
            this.maxValue = max;
            this.minValue = min;
        }

        public double getAvgValue() {
            return avgValue;
        }

        public double getMaxValue() {
            return maxValue;
        }

        public double getMinValue() {
            return minValue;
        }

        @Override
        public String toString() {
            return "Avg: " + avgValue + ", Max: " + maxValue + ", Min: " + minValue;
        }
    }

    public Map<String, Map<String, SensorStats>> calculateMonthlyStats(List<SensorReading> readings) {
        if (readings.isEmpty()) {
            LoggerFile.logInfo("No sensor data available for processing.");
            return Collections.emptyMap();
        }


        Map<String, Map<String, SensorStats>> monthlyStats = readings.stream()
                .collect(Collectors.groupingBy(
                        SensorReading::getSensorType,
                        Collectors.groupingBy(
                                SensorReading::getMonth,
                                Collectors.collectingAndThen(Collectors.toList(), list -> {
                                    if (list.isEmpty()) {
                                        LoggerFile.logInfo("No readings found for a specific month.");
                                        return new SensorStats(0, 0, 0);
                                    }
                                    double avg = list.stream().mapToDouble(SensorReading::getValue).average().orElse(0);
                                    double max = list.stream().mapToDouble(SensorReading::getValue).max().orElse(0);
                                    double min = list.stream().mapToDouble(SensorReading::getValue).min().orElse(0);
                                    return new SensorStats(avg, max, min);
                                })
                        )
                ));

        LoggerFile.logInfo("Successfully processed monthly statistics.");
        return monthlyStats;
    }
}
