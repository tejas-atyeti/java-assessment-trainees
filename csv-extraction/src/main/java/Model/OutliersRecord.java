package Model;

import java.time.LocalDateTime;

public class OutliersRecord {
    private LocalDateTime date;
    private String sensorType;
    private double value;
    private String unit;
    private int locationId;
    private String thresholdExceeded;

    public OutliersRecord(LocalDateTime date, String sensorType, double value, String unit, int locationId, String thresholdExceeded) {
        this.date = date;
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
        this.locationId = locationId;
        this.thresholdExceeded = thresholdExceeded;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
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

    public String getThresholdExceeded() {
        return thresholdExceeded;
    }

    public void setThresholdExceeded(String thresholdExceeded) {
        this.thresholdExceeded = thresholdExceeded;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "OutliersRecord{" +
                "date=" + date +
                ", sensorType='" + sensorType + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", locationId=" + locationId +
                ", thresholdExceeded='" + thresholdExceeded + '\'' +
                '}';
    }
}
