package main.java.data_reporting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class SensorReportGenerator implements ReportGenerator {

    private static final Logger logger = Logger.getLogger(SensorReportGenerator.class.getName());

    @Override
    public void generateReport(List<?> data) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Assessment\\sensordata\\src\\main\\java\\resources\\monthly_stats.csv"))) {
            // Generate the monthly report
            String header = "SensorType, Month, AverageValue, MaxValue, MinValue\n";
            writer.write(header);
            for (Object record : data) {
                writer.write(record.toString());
                writer.write("\n");
            }
            logger.info("Report Stored Successfully");

        } catch (IOException e) {
            logger.severe("Error writing to CSV file: " + e.getMessage());
        }
    }


}