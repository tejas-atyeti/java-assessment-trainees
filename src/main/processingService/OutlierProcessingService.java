package main.processingService;

import main.dataingestion.SensorReading;
import main.dataingestion.Threshold;

import java.util.List;
import java.util.stream.Collectors;

public class OutlierProcessingService {
    public List<SensorReading> detectOutliers(List<SensorReading> readings, List<Threshold> thresholds) {
        return readings.stream()
                .filter(reading -> thresholds.stream()
                        .anyMatch(threshold -> threshold.getSensorType().equals(reading.getSensorType()) &&
                                (reading.getValue() < threshold.getMinThreshold() || reading.getValue() > threshold.getMaxThreshold())))
                .collect(Collectors.toList());
    }
}
