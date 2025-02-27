package ProcessingDataModule;

import Model.OutliersRecord;
import Model.SensorStatistics;
import util.LoggerUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.io.File;

public class CSVWriter {
   public static final String MONTHLY_REPORT_FILE = "C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\CoreJavaAssesment\\java-assessment-trainees\\csv-extraction\\src\\main\\java\\Database\\monthly_records_statistics.csv";
    private static final String DETECTED_OUTLIERS_FILE = "C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\CoreJavaAssesment\\java-assessment-trainees\\csv-extraction\\src\\main\\java\\Database\\detected_outliers.csv";

    public static void writeMonthlyStats(String filePath, List<SensorStatistics> statistics) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write("SensorType,Month,Average,Max,Min");
            writer.newLine();

            for (SensorStatistics stats : statistics) {
                writer.write(stats.getSensorType() + "," +
                        stats.getMonth() + "," +
                        stats.getAverage() + "," +
                        stats.getMax() + "," +
                        stats.getMin());
                writer.newLine();
            }
            System.out.println("Monthly statistics written to " + filePath);
            LoggerUtil.logInfo("Monthly statistics written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            LoggerUtil.logWarning("Error writing to file: " + e.getMessage());
        }
    }

    public static void writeOutliers(List<OutliersRecord> outliers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DETECTED_OUTLIERS_FILE))) {
            writer.write("date,sensor_type,value,unit,location_id,threshold_exceeded");
            writer.newLine();

            for (OutliersRecord outlier : outliers) {
                writer.write(outlier.getDate() + "," +
                        outlier.getSensorType() + "," +
                        outlier.getValue() + "," +
                        outlier.getUnit() + "," +
                        outlier.getLocationId() + "," +
                        outlier.getThresholdExceeded());
                writer.newLine();
            }
            System.out.println("Outliers written to " + DETECTED_OUTLIERS_FILE);
            LoggerUtil.logInfo("Outliers written to " + DETECTED_OUTLIERS_FILE);
        } catch (IOException e) {
            System.err.println("Error writing outliers: " + e.getMessage());
            LoggerUtil.logWarning("Error writing outliers: " + e.getMessage());
        }
    }
}
