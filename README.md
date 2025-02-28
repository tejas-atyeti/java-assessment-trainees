# **Sensor Data Processing and Reporting System**

This is a Java-based application designed to process sensor data from CSV files, calculate monthly statistics, detect outliers, and generate reports.
---

## **What Does It Do?**

This system helps you:
1. **Read Sensor Data**: Load sensor readings and threshold values from CSV files.
2. **Process Data**: Calculate monthly averages, maximums, and minimums for each sensor.
3. **Detect Outliers**: Identify sensor readings that fall outside predefined thresholds.
4. **Generate Reports**: Create two CSV files:
   - `monthly_stats.csv`: Contains monthly statistics (average, max, min).
   - `outliers.csv`: Contains outlier data with details.
5. **Handle Errors**: Log errors and continue processing even if:
   - Thresholds are missing for a sensor type.
   - Invalid data is encountered in the input CSV.

---

## **Requirements**

To run this project, you’ll need:
- **Java 11 or higher** (since we’re using modern Java features).
- A **text editor** or **IDE** (like IntelliJ IDEA or Eclipse) to view and run the code.
- Basic knowledge of the command line (for running the program).

---

## **How to Set Up**

1. **Clone the Repository**:
   Open your terminal and run:
   ```bash
   git clone https://github.com/shaikhosman02/java-assessment-trainees.git
   cd java-assessment-trainees
   ```

2. **Add Your Code**:
   Add your implementation to the `src` folder. The project structure looks like this:
   ```
   java-assessment-trainees/
   ├── src/
   │   ├── com/
   │   │   ├── sensor/
   │   │   │   ├── data/
   │   │   │   │   ├── SensorData.java
   │   │   │   │   ├── ThresholdData.java
   │   │   │   ├── processing/
   │   │   │   │   ├── DataProcessor.java
   │   │   │   │   ├── OutlierDetector.java
   │   │   │   ├── reporting/
   │   │   │   │   ├── SensorReportGenerator.java
   │   │   │   ├── error/
   │   │   │   │   ├── ErrorHandler.java
   │   │   │   ├── Main.java
   ├── resources/
   │   ├── sensor_data.csv
   │   ├── thresholds.csv
   ├── README.md
   ```

3. **Compile and Run**:
   Compile the Java files and run the program:
   ```bash
   javac src/com/sensor/*.java src/com/sensor/**/*.java -d out
   java -cp out com.sensor.Main
   ```

---

## **Input Files**

### **1. Sensor Data (`sensor_data.csv`)**
This file contains sensor readings. Each row has the following fields:
- `date`: Timestamp of the reading (format: `yyyy-MM-dd HH:mm:ss`).
- `sensor_type`: Type of sensor (e.g., temperature, humidity).
- `value`: Sensor reading value.
- `unit`: Unit of measurement (e.g., °C, %).
- `location_id`: Identifier for the sensor location.
- `month`: Month of the reading (format: `yyyy-MM`).

Example:
```
date,sensor_type,value,unit,location_id,month
2024-01-11 00:00:00,pressure,1031.58,hPa,106.0,2024-01
2023-11-01 00:00:00,pressure,990.08,hPa,109.0,2023-11
```

### **2. Threshold Data (`thresholds.csv`)**
This file contains threshold values for sensors. Each row has the following fields:
- `sensor_type`: Type of sensor.
- `min_threshold`: Minimum acceptable value.
- `max_threshold`: Maximum acceptable value.

Example:
```
sensor_type,min_threshold,max_threshold
temperature,15,35
humidity,40,80
pressure,960,1040
```

---

## **Output Files**

After running the program, you’ll get two output files:

### **1. Monthly Statistics (`monthly_stats.csv`)**
This file contains monthly statistics for each sensor type:
- `sensor_type`: Type of sensor.
- `month`: Month of the data (format: `yyyy-MM`).
- `avg_value`: Average value for the month.
- `max_value`: Maximum value for the month.
- `min_value`: Minimum value for the month.

Example:
```
sensor_type,month,avg_value,max_value,min_value
pressure,2024-01,1031.58,1031.58,1031.58
pressure,2023-11,990.08,990.08,990.08
```

### **2. Outliers (`outliers.csv`)**
This file contains sensor readings that are outliers:
- `date`: Timestamp of the reading.
- `sensor_type`: Type of sensor.
- `value`: Sensor reading value.
- `unit`: Unit of measurement.
- `location_id`: Identifier for the sensor location.
- `threshold_exceeded`: Indicates whether the value exceeded the min or max threshold.

Example:
```
date,sensor_type,value,unit,location_id,threshold_exceeded
2023-10-07 00:00:00,pressure,961.35,hPa,102.0,Min
```

---

## **Error Handling**

The system is designed to handle errors gracefully:
- If a file is missing, it logs: `ERR001: File not found`.
- If the data format is invalid, it logs: `ERR002: Invalid data format`.
- If thresholds are missing for a sensor type, it logs: `ERR004: Thresholds not defined`.
- If there’s a processing error, it logs: `ERR003: Processing error`.

The program continues processing even if some rows are invalid or thresholds are missing.

---

## **Best Practices**

This project follows clean code principles:
- **Meaningful Names**: Variables, methods, and classes have clear and descriptive names.
- **Single Responsibility**: Each class and method does one thing and does it well.
- **Error Handling**: Errors are logged, and the program continues running.
- **Efficiency**: Uses Java Streams for processing large datasets efficiently.
