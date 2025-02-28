package outlierdetection;

import com.opencsv.CSVWriter;
import model.OutliersData;
import model.SensorData;
import model.Threshold;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutliersIdentification {

    public static List<OutliersData> detectOutliers(List<SensorData> sensorDataList, List<Threshold> thresholdList) {
        List<OutliersData> outliers = new ArrayList<>();



        for (SensorData data : sensorDataList) {
            String exceeded = null;

            double minValue = thresholdList.stream()
                    .filter(t -> t.getSensorType().equals(data.getSensorType()))
                    .mapToDouble(Threshold::getMinThreshold)
                    .findFirst()
                    .orElse(Double.MIN_VALUE);

            double maxValue = thresholdList.stream().filter(t->t.getSensorType().equals(data.getSensorType()))
                    .mapToDouble(Threshold::getMaxThreshold)
                    .findFirst()
                    .orElse(Double.MAX_VALUE);


            if (data.getValue() < minValue) {
                exceeded = "Min";
            } else if (data.getValue() > maxValue) {
                exceeded = "Max";
            }

            if (exceeded != null) {
                outliers.add(new OutliersData(
                        data.getDate(),
                        data.getSensorType(),
                        data.getValue(),
                        data.getUnit(),
                        data.getLocationId(),
                        exceeded
                ));
            }
        }
        return outliers;
    }

    public static void writeOutliersToCSV(List<OutliersData> outliers, String outputPath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputPath))) {
            String[] header = {"date", "sensor_type", "value", "unit", "location_id", "threshold_exceeded"};
            writer.writeNext(header);

            for (OutliersData outlier : outliers) {
                String[] row = {
                        outlier.getDate().toString(),
                        outlier.getSensorType(),
                        String.valueOf(outlier.getValue()),
                        outlier.getUnit(),
                        outlier.getLocationId(),
                        outlier.getThresholdExceeded()
                };
                writer.writeNext(row);
            }
        }
    }
}
