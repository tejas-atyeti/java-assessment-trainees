package main.java.Service;

import main.java.Entity.Outlier;
import main.java.Entity.SensorData;
import main.java.Entity.Threshold;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutlierService {
    public List<Outlier> detectOutliers(List<SensorData> sensorDataList, Map<String, Threshold> thresholdsMap) {
        List<Outlier> outliers = new ArrayList<>();
        for (SensorData data : sensorDataList) {
            Threshold threshold = thresholdsMap.get(data.getSensorType());
            if (threshold != null) {
                if (data.getValue() < threshold.getMinThreshold()) {
                    outliers.add(new Outlier(data.getDate(), data.getSensorType(), data.getValue(), data.getUnit(), data.getLocationId(), "Min"));
                } else if (data.getValue() > threshold.getMaxThreshold()) {
                    outliers.add(new Outlier(data.getDate(), data.getSensorType(), data.getValue(), data.getUnit(), data.getLocationId(), "Max"));
                }
            }
        }
        return outliers;
    }
}
