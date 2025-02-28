package com.sensor.data;

import java.time.LocalDateTime;

public class SensorData {
    private LocalDateTime date;
    private String sensorType;
    private double value;
    private String unit;
    private String locationId;
    private String month;

    // Constructor
    public SensorData(LocalDateTime date, String sensorType, double value, String unit, String locationId, String month) {
        this.date = date;
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
        this.locationId = locationId;
        this.month = month;
    }

    // Getters
    public LocalDateTime getDate() {
        return date;
    }

    public String getSensorType() {
        return sensorType;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getMonth() {
        return month;
    }
}