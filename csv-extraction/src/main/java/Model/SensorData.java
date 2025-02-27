package Model;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.*;

   public class SensorData {
        private LocalDateTime date;
        private String sensorType;
        private double value;
        private String unit;
        private int locationId;
        private String month;

        public SensorData(LocalDateTime date, String sensorType, double value, String unit, int locationId, String month) {
            this.date = date;
            this.sensorType = sensorType;
            this.value = value;
            this.unit = unit;
            this.locationId = locationId;
            this.month = month;
        }

       public LocalDateTime getDate() {
           return date;
       }

       public void setDate(LocalDateTime date) {
           this.date = date;
       }

       public String getUnit() {
           return unit;
       }

       public void setUnit(String unit) {
           this.unit = unit;
       }

       public int getLocationId() {
           return locationId;
       }

       public void setLocationId(int locationId) {
           this.locationId = locationId;
       }

       public String getSensorType() { return sensorType; }
        public double getValue() { return value; }
        public String getMonth() { return month; }
        @Override
        public String toString() {
            return date + "," + sensorType + "," + value + "," + unit + "," + locationId + "," + month;
        }
    }
