package main.java.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OutlierReport {
    private final LocalDate timestamp;
    private final SensorType sensorType;
    private final double value;
    private final int locationId;
    private final String threshold_exceeded;

    public OutlierReport(LocalDate timestamp, SensorType sensorType, double value, int locationId, String threshold_exceeded) {
        this.timestamp = timestamp;
        this.sensorType = sensorType;
        this.value = value;
        this.locationId = locationId;
        this.threshold_exceeded = threshold_exceeded;
    }

    public String toString() {
        return timestamp + ", " + sensorType + ", " + value + ", " + locationId + ", " + threshold_exceeded;
    }
}
