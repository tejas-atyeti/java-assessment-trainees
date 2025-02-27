package driver;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import pojo.Customer;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DriverClass {

    public List<Customer> readCSV(String fileName) {
        List<Customer> customers = null;
        try {
            // Create a FileReader object to read the CSV file
            FileReader reader = new FileReader(fileName);

            // Use OpenCSV CsvToBeanBuilder to convert CSV into Java objects
            CsvToBean<Customer> csvToBean = new CsvToBeanBuilder<Customer>(reader)
                    .withType(Customer.class)         // Define POJO type (Customer)
                    .withIgnoreLeadingWhiteSpace(true) // Ignore leading whitespace
                    .build();

            // Parse the CSV data into a List of Customer objects
            customers = csvToBean.parse();
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return customers;
    }

    public static void main(String[] args) {
        DriverClass driverClass = new DriverClass();
        List<Customer> customers = driverClass.readCSV("csv-extraction/src/main/resources/customers.csv");

        if (customers != null) {
            System.out.println("Customers Read from CSV:");
            // Print the list of customers
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }
}
