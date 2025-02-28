package com.sensor.error;

import com.sensor.util.Constants;

public class ErrorHandler {

    public static void handleError(String errorCode, String errorMessage) {
        switch (errorCode) {
            case Constants.ERR_CODE_FILE_NOT_FOUND:
                System.err.println("File not found: " + errorMessage);
                break;
            case Constants.ERR_CODE_INVALID_FORMAT:
                System.err.println("Invalid data format: " + errorMessage);
                break;
            case Constants.ERR_CODE_PROCESSING_ERROR:
                System.err.println("Processing error: " + errorMessage);
                break;
            case Constants.ERR_CODE_THRESHOLDS_NOT_DEFINED:
                System.err.println("Thresholds not defined: " + errorMessage);
                break;
            default:
                System.err.println("Unknown error: " + errorMessage);
        }
    }
}