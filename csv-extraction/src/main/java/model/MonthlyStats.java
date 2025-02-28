package model;

public class MonthlyStats {

    private String sensorType;
    private String month;
    private double average;
    private double min;
    private double max;


    public MonthlyStats() {
    }

    public MonthlyStats(String sensorType, String month, double average, double min, double max) {
        this.sensorType = sensorType;
        this.month = month;
        this.average = average;
        this.min = min;
        this.max = max;
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

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
