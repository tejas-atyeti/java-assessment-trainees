package processing;

import com.opencsv.CSVWriter;
import model.SensorData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessingService {

    private static final String RESOURCE_PATH = "src/main/reporting/";

    public static List<String[]> calculateMonthlyStats(List<SensorData> sensorDataList) {
        // Grouping data by sensorType and month
        Map<String, Map<String, List<Double>>> groupedData = sensorDataList.stream().collect(Collectors.groupingBy(SensorData::getSensorType,
                Collectors.groupingBy(SensorData::getMonth, Collectors.mapping(SensorData::getValue, Collectors.toList()))));

        List<String[]> statsList = new ArrayList<>();
        statsList.add(new String[]{"sensor_type", "month", "avg_value", "max_value", "min_value"}); // CSV Header

        // Calculate statistics for each sensor and month
        for (Map.Entry<String, Map<String, List<Double>>> sensorEntry : groupedData.entrySet()) {
            String sensorType = sensorEntry.getKey();
            for (Map.Entry<String, List<Double>> monthEntry : sensorEntry.getValue().entrySet()) {
                String month = monthEntry.getKey();
                List<Double> values = monthEntry.getValue();

                double avg = values.stream().mapToDouble(Double::doubleValue).average().orElse(0);
                double max = values.stream().mapToDouble(Double::doubleValue).max().orElse(0);
                double min = values.stream().mapToDouble(Double::doubleValue).min().orElse(0);

                statsList.add(new String[]{sensorType, month, String.format("%.2f", avg), String.valueOf(max), String.valueOf(min)});
            }
        }
        return statsList;
    }

    public static void writeMonthlyStatsToCSV(String filePath, List<String[]> data) {
        File file = new File(filePath);

        try {
            // Ensure the directory exists
            Files.createDirectories(Paths.get(file.getParent()));

            // If file doesn't exist, create it with headers
            boolean fileExists = file.exists();
            try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) {
                if (!fileExists) {
                    String[] headers = { "sensor_type", "month", "avg_value", "max_value", "min_value"};
                    writer.writeNext(headers);
                }
                writer.writeAll(data, false); // Append data without rewriting headers
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
