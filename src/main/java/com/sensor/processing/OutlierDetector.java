package com.sensor.processing;

import com.sensor.data.SensorData;
import com.sensor.data.ThresholdData;
import com.sensor.error.ErrorHandler;
import com.sensor.util.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class OutlierDetector {

    public List<SensorData> detectOutliers(List<SensorData> sensorData, List<ThresholdData> thresholds) {
        // Create a lookup table for thresholds
        Map<String, ThresholdData> thresholdMap = thresholds.stream()
                .collect(Collectors.toMap(ThresholdData::getSensorType, t -> t));

        List<SensorData> outliers = new ArrayList<>();

        for (SensorData data : sensorData) {
            ThresholdData threshold = thresholdMap.get(data.getSensorType());

            if (threshold == null) {
                // Fallback: Skip outlier detection for this sensor type
                ErrorHandler.handleError(Constants.ERR_CODE_THRESHOLDS_NOT_DEFINED,
                        "Thresholds not defined for sensor type: " + data.getSensorType());
                continue;
            }

            double value = data.getValue();
            if (value < threshold.getMinThreshold() || value > threshold.getMaxThreshold()) {
                outliers.add(data);
            }
        }

        return outliers;
    }
}