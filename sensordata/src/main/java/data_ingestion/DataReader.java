package main.java.data_ingestion;

import java.util.List;

public interface DataReader {

    public List<?> readData(String path);

}
