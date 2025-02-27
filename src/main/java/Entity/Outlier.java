package main.java.Entity;

public class Outlier {
    private String date;
    private String sensorType;
    private double value;
    private String unit;
    private String locationId;
    private String thresholdExceeded;

    public Outlier(String date, String sensorType, double value, String unit, String locationId, String thresholdExceeded) {
        this.date = date;
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
        this.locationId = locationId;
        this.thresholdExceeded = thresholdExceeded;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getThresholdExceeded() {
        return thresholdExceeded;
    }

    public void setThresholdExceeded(String thresholdExceeded) {
        this.thresholdExceeded = thresholdExceeded;
    }

    @Override
    public String toString() {
        return "Outlier{" +
                "date='" + date + '\'' +
                ", sensorType='" + sensorType + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", locationId='" + locationId + '\'' +
                ", thresholdExceeded='" + thresholdExceeded + '\'' +
                '}';
    }
}
