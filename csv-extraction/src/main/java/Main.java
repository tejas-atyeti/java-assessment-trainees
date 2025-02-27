import CSVReader.CSVReader;
import Model.OutliersRecord;
import Model.SensorData;
import Model.SensorStatistics;
import Model.ThresholdData;
import ProcessingDataModule.CSVWriter;
import ProcessingDataModule.OutlierService;
import ProcessingDataModule.StatisticsCalculationService;
import util.LoggerUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        StatisticsCalculationService statisticsCalculationService = new StatisticsCalculationService();
        OutlierService outlierService = new OutlierService();

        List<SensorData> sensorDataList = CSVReader.readFromSensorData("C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\CoreJavaAssesment\\java-assessment-trainees\\csv-extraction\\src\\main\\java\\CSVFiles\\sensor_data.csv");
        Map<String, ThresholdData> thresholdMap = CSVReader.readFromThresholds("C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\CoreJavaAssesment\\java-assessment-trainees\\csv-extraction\\src\\main\\java\\CSVFiles\\thresholds.csv");


        Map<String, Map<String, SensorStatistics>> statisticsMap = statisticsCalculationService.calculateMonthlyStatistics(sensorDataList);


        List<SensorStatistics> statisticsList = statisticsMap.values().stream()
                .flatMap(innerMap -> innerMap.values().stream())
                .collect(Collectors.toList());


        CSVWriter.writeMonthlyStats(CSVWriter.MONTHLY_REPORT_FILE, statisticsList);


        List<OutliersRecord> outliers = outlierService.detectOutliers(sensorDataList, thresholdMap);
        CSVWriter.writeOutliers(outliers);

        System.out.println("Processing complete.");
        LoggerUtil.logInfo("Processing complete.");
    }

    }
