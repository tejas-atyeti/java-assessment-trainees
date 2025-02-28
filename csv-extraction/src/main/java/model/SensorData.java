package model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import java.time.LocalDate;

public class SensorData {

    @CsvDate("yyyy-MM-dd[ HH:mm:ss]")
    @CsvBindByName(column = "date")
    private LocalDate date;

    @CsvBindByName(column = "sensor_type")  // Matches CSV column name exactly
    private String sensorType;

    @CsvBindByName(column = "value")
    private double value;

    @CsvBindByName(column = "unit")
    private String unit;

    @CsvBindByName(column = "location_id")  // Matches CSV column name exactly
    private String locationId;

    // Getters and setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getMonth (){
        return (date != null) ? date.getMonth().toString() : "UNKNOWN";
    }

    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getLocationId() { return locationId; }
    public void setLocationId(String locationId) { this.locationId = locationId; }

    @Override
    public String toString() {
        return "SensoryData{" +
                "date=" + date +
                ", sensorType='" + sensorType + '\'' +
                ", value=" + value +
                ", unit='" + unit + '\'' +
                ", locationId='" + locationId + '\'' +

                '}';
    }
}
