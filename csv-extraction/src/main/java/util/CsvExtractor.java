package util;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import model.SensorData;
import model.Threshold;

import java.io.*;
import java.util.*;

public class CsvExtractor {


    // Method to read the CSV and return a List of Sensory objects
    public static List<SensorData> readSensorDataCSV(String fileName) {
        List<SensorData> sensorDataList = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            // Convert CSV into Java objects
            CsvToBean<SensorData> csvToBean = new CsvToBeanBuilder<SensorData>(reader)
                    .withType(SensorData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // Parse the CSV data
            sensorDataList = csvToBean.parse();
        } catch (IOException e) {
            System.err.println("ERR001: File not found");
        }
        return sensorDataList;
    }


    public static List<Threshold> readThresholdCSV(String fileName) {
        List<Threshold> thresholdList = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            // Convert CSV into Java objects
            CsvToBean<Threshold> csvToBean = new CsvToBeanBuilder<Threshold>(reader)
                    .withType(Threshold.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // Parse the CSV data
            thresholdList = csvToBean.parse();
        } catch (IOException e) {
            System.err.println("ERR001: File not found");
        }
        return thresholdList;
    }
}

