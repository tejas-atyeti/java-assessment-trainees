package main.java.pojo;

public class ThresholdData {

    private SensorType type;
    private double minThreshold;
    private double maxThreshold;

    public ThresholdData(SensorType type, double minThreshold, double maxThreshold) {
        this.type = type;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
    }

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
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
        return "ThresholdData{" +
                "type=" + type +
                ", minThreshold=" + minThreshold +
                ", maxThreshold=" + maxThreshold +
                '}';
    }
}
