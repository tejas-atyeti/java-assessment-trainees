package main.java.outliers_detection;

import main.java.pojo.OutlierReport;
import main.java.pojo.SensorData;
import main.java.pojo.ThresholdData;

import java.util.ArrayList;
import java.util.List;

public class CSVOutliersDetector {

    public List<OutlierReport> detectOutliers(List<SensorData> sensorData, List<ThresholdData> thresholdData) {

        List<OutlierReport> outlierReports = new ArrayList<>();
        sensorData.stream().forEach(data -> {
            int outlier = isOutlier(data, thresholdData);
            if (outlier==1) {
                outlierReports.add(new OutlierReport(data.getTimestamp(), data.getType(), data.getValue(), data.getLocationId(), "High"));
            } else if (outlier == -1) {
                outlierReports.add(new OutlierReport(data.getTimestamp(), data.getType(), data.getValue(), data.getLocationId(), "Low"));
            }
        });
        return outlierReports;
    }

    private int isOutlier(SensorData sensorData, List<ThresholdData> thresholdData) {

        for(ThresholdData data : thresholdData){
            if(sensorData.getValue() > data.getMaxThreshold()){
                return 1;
            }
            else if(sensorData.getValue() < data.getMinThreshold()){
                return -1;
            }
        }
        return 0;
    }
}
