package Model;

public class SensorStatistics {
    private String sensorType;
    private String month;
    private double average;
    private double min;
    private double max;

    public SensorStatistics(String sensorType,String month, double average, double min, double max) {
        this.sensorType = sensorType;
        this.month=month;
        this.average = average;
        this.min = min;
        this.max = max;
    }

    public String getSensorType() {
        return sensorType;
    }

    public double getAverage() {
        return average;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "SensorStatistics{" +
                "sensorType='" + sensorType + '\'' +
                ", month='" + month + '\'' +
                ", average=" + average +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
