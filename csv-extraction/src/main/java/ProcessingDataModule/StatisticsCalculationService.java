package ProcessingDataModule;

import Model.SensorData;
import Model.SensorStatistics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsCalculationService {
    public Map<String, Map<String, SensorStatistics>> calculateMonthlyStatistics(List<SensorData> sensorDataList) {
        return sensorDataList.stream()
                .collect(Collectors.groupingBy(
                        SensorData::getSensorType,
                        Collectors.groupingBy(
                                SensorData::getMonth,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        dataList -> {
                                            double avg = dataList.stream()
                                                    .collect(Collectors.averagingDouble(SensorData::getValue));
                                            double max = dataList.stream()
                                                    .mapToDouble(SensorData::getValue)
                                                    .max()
                                                    .orElse(Double.NaN);
                                            double min = dataList.stream()
                                                    .mapToDouble(SensorData::getValue)
                                                    .min()
                                                    .orElse(Double.NaN);

                                            // Ensure month is extracted
                                            String month = dataList.get(0).getMonth();

                                            return new SensorStatistics(dataList.get(0).getSensorType(), month, avg, min, max);
                                        }
                                )
                        )
                ));
    }
}
