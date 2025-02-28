package main.java.outliers_detection;

import main.java.pojo.OutlierReport;
import main.java.pojo.SensorData;
import main.java.pojo.ThresholdData;

import java.util.ArrayList;
import java.util.List;

public class OutliersDetector {

    public List<OutlierReport> detectOutliers(List<SensorData> sensorData, List<ThresholdData> thresholdData) {

        List<OutlierReport> outlierReports = new ArrayList<>();
        sensorData.forEach(data -> {
            for(ThresholdData tdata: thresholdData){
                if(data.getType().equals(tdata.getType())){
                    int outlier = isOutlier(data, tdata);
                    if (outlier==1) {
                        outlierReports.add(new OutlierReport(data.getTimestamp(), data.getType(), data.getValue(), data.getLocationId(), "High"));
                    } else if (outlier == -1) {
                        outlierReports.add(new OutlierReport(data.getTimestamp(), data.getType(), data.getValue(), data.getLocationId(), "Low"));
                    }
                }
            }

        });
        return outlierReports;
    }

    private int isOutlier(SensorData sensorData, ThresholdData thresholdData) {

        if(sensorData.getValue() < thresholdData.getMinThreshold()){
            return -1;
        } else if (sensorData.getValue() > thresholdData.getMaxThreshold()) {
            return 1;
        }
        return 0;
    }
}
