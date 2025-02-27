package main.java.Service;


import main.java.Entity.MonthlyStats;
import main.java.Entity.SensorData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SensorService {

    public Map<String, MonthlyStats> calculateMonthlyStats(List<SensorData> sensorDataList) {
        Map<String, List<SensorData>> groupedByMonth = new HashMap<>();
        for (SensorData data : sensorDataList) {
            String key = data.getSensorType() + "_" + getMonth(data.getDate());
            groupedByMonth.putIfAbsent(key, new ArrayList<>());
            groupedByMonth.get(key).add(data);
        }

        Map<String, MonthlyStats> monthlyStatsMap = new HashMap<>();
        for (Map.Entry<String, List<SensorData>> entry : groupedByMonth.entrySet()) {
            List<SensorData> monthlyData = entry.getValue();
            double avg = monthlyData.stream().mapToDouble(SensorData::getValue).average().orElse(0);
            double max = monthlyData.stream().mapToDouble(SensorData::getValue).max().orElse(0);
            double min = monthlyData.stream().mapToDouble(SensorData::getValue).min().orElse(0);
            String sensorType = entry.getKey().split("_")[0];
            String month = entry.getKey().split("_")[1];
            monthlyStatsMap.put(entry.getKey(), new MonthlyStats(sensorType, month, avg, max, min));
        }
        return monthlyStatsMap;
    }

    // Get Month from Date (Format: yyyy-MM-dd)
    public String getMonth(String date) {
        String[] parts = date.split("-");
        return parts[1];
    }

}
