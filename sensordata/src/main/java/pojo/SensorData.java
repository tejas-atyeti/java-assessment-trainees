package main.java.pojo;

import java.time.LocalDate;

public class SensorData {

    private LocalDate timestamp;
    private SensorType type;
    private double value;
    private String unit;
    private int locationId;

    public SensorData(){}

    public SensorData(LocalDate timestamp, SensorType type, double value, String unit, int locationId) {
        this.timestamp = timestamp;
        this.type = type;
        this.value = value;
        this.unit = unit;
        this.locationId = locationId;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
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
