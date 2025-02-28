package driver;


import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import model.Customer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public void writeCSV(String fileName, List<Customer> persons) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                '\\',
                "\n")) {
            // Write header
            String[] header = {"Name", "Age", "Email"};
            writer.writeNext(header);

            // Write data rows
            for (Customer person : persons) {
                String[] personData = {person.getName(), String.valueOf(person.getAge()), person.getEmail()};
                writer.writeNext(personData);
            }
            System.out.println("CSV file was created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
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

        List<Customer> customersToWrite = new ArrayList<>();
        customersToWrite.add(new Customer("John Doe", 30, "john.doe@example.com"));
        customersToWrite.add(new Customer("Jane Smith", 25, "jane.smith@example.com"));
        customersToWrite.add(new Customer("Alice Johnson", 40, "alice.johnson@example.com"));

        // Create an instance of the CSVWriterExample class
        DriverClass csvWriterExample = new DriverClass();

        // Write the list of Customer objects to a CSV file
        csvWriterExample.writeCSV("customers_write.csv", customersToWrite);
    }
}
