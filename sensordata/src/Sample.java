import main.java.data_ingestion.SensorDataReader;
import main.java.data_ingestion.ThresholdDataReader;
import main.java.data_processing.SensorDataProcessor;
import main.java.data_reporting.OutlierReportGenerator;
import main.java.data_reporting.SensorReportGenerator;
import main.java.outliers_detection.OutliersDetector;
import main.java.pojo.OutlierReport;
import main.java.pojo.SensorData;
import main.java.pojo.SensorReport;
import main.java.pojo.ThresholdData;
import java.util.List;

public class Sample {

    public static void main(String[] args) {

        List<SensorData> sensorDataList = (List<SensorData>) new SensorDataReader().readData("C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Assessment\\sensordata\\src\\main\\java\\resources\\sensor_data.csv");

        List<ThresholdData> thresholdDataList = (List<ThresholdData>) new ThresholdDataReader().readData("C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Assessment\\sensordata\\src\\main\\java\\resources\\thresholds.csv");

        List<SensorReport> sensorReports = new SensorDataProcessor().processData(sensorDataList,thresholdDataList);

        List<OutlierReport> outlierReports = new OutliersDetector().detectOutliers(sensorDataList,thresholdDataList);

        new SensorReportGenerator().generateReport(sensorReports);

        new OutlierReportGenerator().generateReport(outlierReports);
    }
}