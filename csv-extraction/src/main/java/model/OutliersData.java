package model;


import com.opencsv.bean.CsvBindByName;

import java.time.LocalDate;

public class OutliersData {

    @CsvBindByName(column = "date")
    private LocalDate date;

    @CsvBindByName(column = "sensor_type")
    private String sensorType;

    @CsvBindByName(column = "value")
    private double value;

    @CsvBindByName(column = "unit")
    private String unit;

    @CsvBindByName(column = "location_id")
    private String locationId;

    @CsvBindByName(column = "threshold_exceeded")
    private String thresholdExceeded; // "Min" or "Max"

    public OutliersData(LocalDate date, String sensorType, double value, String unit, String locationId, String thresholdExceeded) {
        this.date = date;
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
        this.locationId = locationId;
        this.thresholdExceeded = thresholdExceeded;
    }

    // Getters
    public LocalDate getDate() {
        return date;
    }

    public String getSensorType() {
        return sensorType;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getThresholdExceeded() {
        return thresholdExceeded;
    }

    @Override
    public String toString() {
        return "OutlierData{" +
                "date=" + date +
                ", sensorType='" + sensorType + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", locationId='" + locationId + '\'' +
                ", thresholdExceeded='" + thresholdExceeded + '\'' +
                '}';
    }
}
