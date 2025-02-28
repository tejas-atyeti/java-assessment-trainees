package dataingestion;

import outlierdetection.OutliersIdentification;
import model.OutliersData;
import model.SensorData;
import java.io.IOException;
import java.util.List;
import model.Threshold;
import processing.ProcessingService;
import util.CsvExtractor;


public class SensorDataDriver {

    public static void main(String[] args) {

        // Read from CSV
        String sensoryInputFile = "csv-extraction/src/main/resources/sensor_data.csv";

        String thresholdInputFile = "csv-extraction/src/main/resources/thresholds.csv";

        List<SensorData> sensorDataList = CsvExtractor.readSensorDataCSV(sensoryInputFile);
        List<Threshold> thresholdList = CsvExtractor.readThresholdCSV(thresholdInputFile);


        List<String[]> statsList = ProcessingService.calculateMonthlyStats(sensorDataList);
        String statsOutputFile = "csv-extraction/src/main/java/reporting/monthly_stats.csv";
        ProcessingService.writeMonthlyStatsToCSV(statsOutputFile, statsList);


        List<OutliersData> outliers = OutliersIdentification.detectOutliers(sensorDataList, thresholdList);


        System.out.println("Number of outliers detected: " + outliers.size());

        String outliersOutputFile = "csv-extraction/src/main/java/reporting/outliers.csv";

        try {
            OutliersIdentification.writeOutliersToCSV(outliers, outliersOutputFile);
        } catch (IOException e) {
            System.err.println("Error writing outliers to CSV file: " + e.getMessage());
        }

    }

}


