package driver;


import com.opencsv.CSVReader;

import java.io.FileReader;

public class DriverClass {
    public static void main(String[] args) {
        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            String filename = "csv-extraction/src/main/resources/customers.csv";
            FileReader filereader = new FileReader(filename);

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                for (String cell : nextRecord) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

            // Reading the CSV file and converting it into Customer objects
//        List<Customer> customers = csvExtractor.readCSV("csv-extraction/src/main/resources/customers.csv");
//
//        // Printing out the Customer objects
//        System.out.println("Customers Read from CSV:");
//        customers.forEach(System.out::println);
//
//        // Serializing the list of Customer objects to a file
//        csvExtractor.serializeCustomers(customers, "customers.ser");
//
//        // Deserializing the list of Customer objects back from the file
//        List<Customer> deserializedCustomers = csvExtractor.deserializeCustomers("customers.ser");
//
//        // Printing out the deserialized Customer objects
//        System.out.println("\nDeserialized Customers:");
//        deserializedCustomers.forEach(System.out::println);
    }
}
