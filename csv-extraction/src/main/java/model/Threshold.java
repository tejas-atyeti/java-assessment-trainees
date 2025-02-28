package model;

import com.opencsv.bean.CsvBindByName;

public class Threshold {

    @CsvBindByName(column = "sensor_type")
    private String sensorType;

    @CsvBindByName(column = "min_threshold")
    private int minThreshold;

    @CsvBindByName(column = "max_threshold")
    private int maxThreshold;

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getMinThreshold() {
        return minThreshold;
    }

    public void setMinThreshold(int minThreshold) {
        this.minThreshold = minThreshold;
    }

    public int getMaxThreshold() {
        return maxThreshold;
    }

    public void setMaxThreshold(int maxThreshold) {
        this.maxThreshold = maxThreshold;
    }

    @Override
    public String toString() {
        return "SensorThreshold{" +
                "sensorType='" + sensorType + '\'' +
                ", minThreshold=" + minThreshold +
                ", maxThreshold=" + maxThreshold +
                '}';
    }

}

