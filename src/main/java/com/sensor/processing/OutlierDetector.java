package com.sensor.processing;


import com.sensor.data.SensorData;
import com.sensor.data.ThresholdData;

import java.util.ArrayList;
import java.util.List;

public class OutlierDetector {

    public List<SensorData> detectOutliers(List<SensorData> sensorData, List<ThresholdData> thresholds) {
        List<SensorData> outliers = new ArrayList<>();

        for (SensorData data : sensorData) {
            ThresholdData threshold = thresholds.stream()
                    .filter(t -> t.getSensorType().equals(data.getSensorType()))
                    .findFirst()
                    .orElse(null);

            if (threshold != null) {
                double value = data.getValue();
                if (value < threshold.getMinThreshold() || value > threshold.getMaxThreshold()) {
                    outliers.add(data);
                }
            }
        }

        return outliers;
    }
}