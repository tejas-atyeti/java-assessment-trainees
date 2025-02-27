package ProcessingDataModule;

import Model.OutliersRecord;
import Model.SensorData;
import Model.ThresholdData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutlierService {
    public List<OutliersRecord> detectOutliers(List<SensorData> sensorDataList, Map<String, ThresholdData> thresholds) {
        return sensorDataList.stream()
                .filter(data -> thresholds.containsKey(data.getSensorType()))
                .map(data -> {
                    ThresholdData threshold = thresholds.get(data.getSensorType());
                    String thresholdExceeded = null;

                    if (data.getValue() < threshold.getMinThreshold()) {
                        thresholdExceeded = "Min";
                    } else if (data.getValue() > threshold.getMaxThreshold()) {
                        thresholdExceeded = "Max";
                    }

                    if (thresholdExceeded != null) {
                        return new OutliersRecord(
                                data.getDate(),
                                data.getSensorType(),
                                data.getValue(),
                                data.getUnit(),
                                data.getLocationId(),
                                thresholdExceeded
                        );
                    }
                    return null;
                })
                .filter(outlier -> outlier != null)
                .collect(Collectors.toList());
    }
}
