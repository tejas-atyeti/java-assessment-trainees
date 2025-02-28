package com.sensor.data;

public class ThresholdData {
    private String sensorType;
    private double minThreshold;
    private double maxThreshold;

    // Constructor
    public ThresholdData(String sensorType, double minThreshold, double maxThreshold) {
        this.sensorType = sensorType;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
    }

    // Getters
    public String getSensorType() {
        return sensorType;
    }

    public double getMinThreshold() {
        return minThreshold;
    }

    public double getMaxThreshold() {
        return maxThreshold;
    }
}