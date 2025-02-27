
import main.dataingestion.CsvHandler;
import main.dataingestion.SensorReading;
import main.dataingestion.Threshold;
import main.processingService.SensorProcessingService;
import main.processingService.OutlierProcessingService;
import main.reporting.CsvWriter;
import main.logging.LoggerFile;

import java.util.List;
import java.util.Map;

public class SensorProcessingApplication {
    private static final String MONTHLY_STATS_CSV = "src/main/reporting/monthly_stats.csv";
    private static final String OUTLIERS_CSV = "src/main/reporting/outliers.csv";

    public static void main(String[] args) {
        CsvHandler csvHandler = new CsvHandler();
        List<SensorReading> sensorData = csvHandler.readSensorDataCsv();
        List<Threshold> thresholdData = csvHandler.readThresholdCsv();

        if (sensorData.isEmpty()) {
            LoggerFile.logInfo("No sensor data found. Exiting...");
            return;
        }

        SensorProcessingService processingService = new SensorProcessingService();
        Map<String, Map<String, SensorProcessingService.SensorStats>> monthlyStats = processingService.calculateMonthlyStats(sensorData);

        CsvWriter.writeMonthlyStats(MONTHLY_STATS_CSV, monthlyStats);
        LoggerFile.logInfo("Monthly statistics written to " + MONTHLY_STATS_CSV);

        OutlierProcessingService outlierService = new OutlierProcessingService();
        List<SensorReading> outliers = outlierService.detectOutliers(sensorData, thresholdData);

        CsvWriter.writeToCsv(OUTLIERS_CSV, outliers);
        LoggerFile.logInfo("Outliers written to " + OUTLIERS_CSV);
    }
}
