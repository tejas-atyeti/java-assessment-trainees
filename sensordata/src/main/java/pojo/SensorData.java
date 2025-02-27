package main.java.pojo;

import java.time.LocalDateTime;

public class SensorData {

    private LocalDateTime timestamp;
    private SensorType type;
    private double value;
    private String unit;
    private int locationId;

    public SensorData(){}

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "timestamp=" + timestamp +
                ", type=" + type +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", location='" + locationId + '\'' +
                '}';
    }
}
