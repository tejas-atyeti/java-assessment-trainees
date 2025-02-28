package com.sensor.util;

public class Constants {
    public static final String ERR_CODE_FILE_NOT_FOUND = "ERR001";
    public static final String ERR_CODE_INVALID_FORMAT = "ERR002";
    public static final String ERR_CODE_PROCESSING_ERROR = "ERR003";
    public static final String ERR_CODE_THRESHOLDS_NOT_DEFINED = "ERR004";

    public static final String MONTHLY_STATS_HEADER = "sensor_type,month,avg_value,max_value,min_value\n";
    public static final String OUTLIERS_HEADER = "date,sensor_type,value,unit,location_id,threshold_exceeded\n";
}