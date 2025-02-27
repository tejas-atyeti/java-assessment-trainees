package main.dataingestion;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SensorReading {
    private LocalDateTime dateTime;
    private String sensorType;
    private double value;
    private String unit;
    private double locationId;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public SensorReading(String date, String sensorType, double value, String unit, double locationId) {
        this.dateTime = parseDate(date);
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
        this.locationId = locationId;
    }

    private LocalDateTime parseDate(String date) {
        if (date == null || date.trim().isEmpty()) {

            return LocalDateTime.now();
        }
        try {
            return LocalDateTime.parse(date, DATE_TIME_FORMATTER);
        } catch (Exception e) {
            try {
                return LocalDate.parse(date, DATE_FORMATTER).atStartOfDay();
            } catch (Exception ex) {
                throw new IllegalArgumentException("Invalid date format: " + date);
            }
        }
    }

    public String getMonth() {
        return dateTime.getYear() + "-" + String.format("%02d", dateTime.getMonthValue());
    }

    public double getValue() { return value; }
    public String getSensorType() {
        return sensorType;
    }

    @Override
    public String toString() {
        return dateTime + "," + sensorType + "," + value + "," + unit + "," + locationId;
    }

}



