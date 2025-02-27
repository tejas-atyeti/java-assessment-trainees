package main.java.DAO.IMPL;

import main.java.Entity.MonthlyStats;
import main.java.Entity.Outlier;
import main.java.Entity.SensorData;
import main.java.Entity.Threshold;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvHandler {
    // Read sensor data from CSV
    public List<SensorData> readSensorData(String filePath) throws IOException {
        List<SensorData> sensorDataList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length == 6) {
                String date = fields[0];
                String sensorType = fields[1];
                double value = Double.parseDouble(fields[2]);
                String unit = fields[3];
                String locationId = fields[4];

                sensorDataList.add(new SensorData(date, sensorType, value, unit, locationId));
            } else {
                System.err.println("Invalid data format in line: " + line);
            }
        }
        br.close();
        return sensorDataList;
    }

    // Read threshold data from CSV
    public Map<String, Threshold> readThresholds(String filePath) throws IOException {
        Map<String, Threshold> thresholdsMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length == 3) {
                String sensorType = fields[0];
                double minThreshold = Double.parseDouble(fields[1]);
                double maxThreshold = Double.parseDouble(fields[2]);
                thresholdsMap.put(sensorType, new Threshold(sensorType, minThreshold, maxThreshold));
            } else {
                System.err.println("Invalid data format in line: " + line);
            }
        }
        br.close();
        return thresholdsMap;
    }

    // Write monthly stats to CSV
    public void writeMonthlyStats(Map<String, MonthlyStats> monthlyStatsMap, String outputFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write("sensor_type,month,avg_value,max_value,min_value\n");
        for (MonthlyStats stats : monthlyStatsMap.values()) {
            writer.write(stats.getSensorType() + "," + stats.getMonth() + "," + stats.getAvgValue() + "," + stats.getMaxValue() + "," + stats.getMinValue() + "\n");
        }
        writer.close();
    }

    // Write outliers to CSV
    public void writeOutliers(List<Outlier> outliers, String outputFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write("date,sensor_type,value,unit,location_id,threshold_exceeded\n");
        for (Outlier outlier : outliers) {
            writer.write(outlier.getDate() + "," + outlier.getSensorType() + "," + outlier.getValue() + "," + outlier.getUnit() + "," + outlier.getLocationId() + "," + outlier.getThresholdExceeded() + "\n");
        }
        writer.close();
    }
}
