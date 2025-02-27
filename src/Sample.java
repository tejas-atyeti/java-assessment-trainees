import main.java.DAO.IMPL.CsvHandler;
import main.java.Entity.MonthlyStats;
import main.java.Entity.Outlier;
import main.java.Entity.SensorData;
import main.java.Entity.Threshold;
import main.java.Service.OutlierService;
import main.java.Service.SensorService;

import java.util.List;
import java.util.Map;

public class Sample {
    public static void main(String[] args) {
        try {
            String sensorDataFile = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\rohit\\java-assessment\\src\\sensor_data.csv";
            String thresholdsFile = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\rohit\\java-assessment\\src\\thresholds.csv";
            String monthlyStatsFile = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\rohit\\java-assessment\\src\\monthly_stats.csv";
            String outliersFile = "C:\\Users\\RohitPatil\\OneDrive - Atyeti Inc\\Desktop\\rohit\\java-assessment\\src\\outliers.csv";

            CsvHandler csvHandler = new CsvHandler();
            SensorService sensorService = new SensorService();
            OutlierService outlierService = new OutlierService();

            List<SensorData> sensorDataList = csvHandler.readSensorData(sensorDataFile);
            Map<String, Threshold> thresholdsMap = csvHandler.readThresholds(thresholdsFile);

            // Calculate Monthly Stats
            Map<String, MonthlyStats> monthlyStatsMap = sensorService.calculateMonthlyStats(sensorDataList);

            // Detect Outliers
            List<Outlier> outliers = outlierService.detectOutliers(sensorDataList, thresholdsMap);

            // Write Reports
            csvHandler.writeMonthlyStats(monthlyStatsMap, monthlyStatsFile);
            csvHandler.writeOutliers(outliers, outliersFile);

            System.out.println("Reports generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}