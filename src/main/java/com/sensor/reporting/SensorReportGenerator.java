package com.sensor.reporting;

import com.sensor.data.SensorData;
import com.sensor.error.ErrorHandler;
import com.sensor.util.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SensorReportGenerator {

    public void generateMonthlyStatsReport(Map<String, Map<String, Double>> monthlyStats, String outputPath) {
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(Constants.MONTHLY_STATS_HEADER);
            writeMonthlyStatsToFile(writer, monthlyStats);
        } catch (IOException e) {
            ErrorHandler.handleError(Constants.ERR_CODE_PROCESSING_ERROR, "Error generating monthly stats report: " + e.getMessage());
        }
    }

    private void writeMonthlyStatsToFile(FileWriter writer, Map<String, Map<String, Double>> monthlyStats) throws IOException {
        for (Map.Entry<String, Map<String, Double>> entry : monthlyStats.entrySet()) {
            String sensorType = entry.getKey();
            Map<String, Double> stats = entry.getValue();

            for (Map.Entry<String, Double> stat : stats.entrySet()) {
                writer.write(String.format("%s,%s,%.2f\n", sensorType, stat.getKey(), stat.getValue()));
            }
        }
    }

    public void generateOutliersReport(List<SensorData> outliers, String outputPath) {
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(Constants.OUTLIERS_HEADER);
            writeOutliersToFile(writer, outliers);
        } catch (IOException e) {
            ErrorHandler.handleError(Constants.ERR_CODE_PROCESSING_ERROR, "Error generating outliers report: " + e.getMessage());
        }
    }

    private void writeOutliersToFile(FileWriter writer, List<SensorData> outliers) throws IOException {
        for (SensorData outlier : outliers) {
            writer.write(String.format("%s,%s,%.2f,%s,%s,%s\n",
                    outlier.getDate(),
                    outlier.getSensorType(),
                    outlier.getValue(),
                    outlier.getUnit(),
                    outlier.getLocationId(),
                    determineThresholdExceeded(outlier.getValue())));
        }
    }

    private String determineThresholdExceeded(double value) {
        return value < 0 ? "Min" : "Max";
    }
}