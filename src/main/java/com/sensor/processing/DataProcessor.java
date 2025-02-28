package com.sensor.processing;

import com.sensor.data.SensorData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessor {

    public Map<String, Map<String, Double>> calculateMonthlyAverages(List<SensorData> sensorData) {
        Map<String, Map<String, Double>> monthlyAverages = new HashMap<>();

        for (SensorData data : sensorData) {
            String sensorType = data.getSensorType();
            String month = data.getMonth(); // Use the month field
            double value = data.getValue();

            monthlyAverages.computeIfAbsent(sensorType, k -> new HashMap<>())
                    .merge(month, value, (oldValue, newValue) -> (oldValue + newValue) / 2);
        }

        return monthlyAverages;
    }

    public Map<String, Map<String, Double>> calculateMonthlyMax(List<SensorData> sensorData) {
        Map<String, Map<String, Double>> monthlyMax = new HashMap<>();

        for (SensorData data : sensorData) {
            String sensorType = data.getSensorType();
            String month = data.getMonth(); // Use the month field
            double value = data.getValue();

            monthlyMax.computeIfAbsent(sensorType, k -> new HashMap<>())
                    .merge(month, value, Math::max);
        }

        return monthlyMax;
    }

    public Map<String, Map<String, Double>> calculateMonthlyMin(List<SensorData> sensorData) {
        Map<String, Map<String, Double>> monthlyMin = new HashMap<>();

        for (SensorData data : sensorData) {
            String sensorType = data.getSensorType();
            String month = data.getMonth(); // Use the month field
            double value = data.getValue();

            monthlyMin.computeIfAbsent(sensorType, k -> new HashMap<>())
                    .merge(month, value, Math::min);
        }

        return monthlyMin;
    }
}