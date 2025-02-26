package main.java;

import main.java.pojo.Customer;
import main.java.util.CsvExtractor;

import java.util.List;

public class DriverClass {
    public static void main(String[] args) {
        CsvExtractor csvExtractor = new CsvExtractor();

        // Reading the CSV file and converting it into Customer objects
        List<Customer> customers = csvExtractor.readCSV("src/main/resources/customers.csv");

        // Printing out the Customer objects
        System.out.println("Customers Read from CSV:");
        customers.forEach(System.out::println);

        // Serializing the list of Customer objects to a file
        csvExtractor.serializeCustomers(customers, "customers.ser");

        // Deserializing the list of Customer objects back from the file
        List<Customer> deserializedCustomers = csvExtractor.deserializeCustomers("customers.ser");

        // Printing out the deserialized Customer objects
        System.out.println("\nDeserialized Customers:");
        deserializedCustomers.forEach(System.out::println);
    }
}
