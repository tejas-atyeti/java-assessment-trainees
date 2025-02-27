package main.java.Entity;

public class MonthlyStats {
    private String sensorType;
    private String month;
    private double avgValue;
    private double maxValue;
    private double minValue;


    public MonthlyStats(String sensorType, String month, double avgValue, double maxValue, double minValue) {
        this.sensorType = sensorType;
        this.month = month;
        this.avgValue = avgValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(double avgValue) {
        this.avgValue = avgValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    @Override
    public String toString() {
        return "MonthlyStats{" +
                "sensorType='" + sensorType + '\'' +
                ", month='" + month + '\'' +
                ", avgValue=" + avgValue +
                ", maxValue=" + maxValue +
                ", minValue=" + minValue +
                '}';
    }
}
