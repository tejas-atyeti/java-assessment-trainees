package main.java.Entity;

public class Threshold {

    private String sensorType;
    private double minThreshold;
    private double maxThreshold;

    public Threshold(String sensorType, double minThreshold, double maxThreshold) {
        this.sensorType = sensorType;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public double getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(double minThreshold) {
        this.minThreshold = minThreshold;
    }

    public double getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(double maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    @Override
    public String toString() {
        return "Threshold{" +
                "sensorType='" + sensorType + '\'' +
                ", minThreshold=" + minThreshold +
                ", maxThreshold=" + maxThreshold +
                '}';
    }
}