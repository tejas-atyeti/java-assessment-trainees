package Model;

public class ThresholdData {
    private String sensorType;
    private double minThreshold;
    private double maxThreshold;

    public ThresholdData(String sensorType, double minThreshold, double maxThreshold) {
        this.sensorType = sensorType;
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
    }

    public double getMinThreshold() {
        return minThreshold;
    }
    public double getMaxThreshold() {
        return maxThreshold;
    }
    @Override
    public String toString() {
        return sensorType + "," + minThreshold + "," + maxThreshold;
    }
}

