package main.java.pojo;

public class SensorReport {
    private SensorType sensorType;
    private String month;
    private double averageValue;
    private double maxValue;
    private double minValue;

    public SensorReport() {
    }
    public SensorReport(SensorType sensorType, String month, double averageValue, double maxValue, double minValue) {
        this.sensorType = sensorType;
        this.month = month;
        this.averageValue = averageValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    @Override
    public String toString() {
        return sensorType + ", " + month + ", " + averageValue + ", " + maxValue + ", " + minValue;
    }
}
