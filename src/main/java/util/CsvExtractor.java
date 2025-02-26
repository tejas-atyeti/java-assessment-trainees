package main.java.util;

import main.java.pojo.Customer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CsvExtractor {
    // Method to read the CSV and return a List of Customer objects
    public List<Customer> readCSV(String fileName) {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine(); // Skip header row if it exists
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 3) { // Assuming CSV has 3 columns: Name, Age, Email
                    String name = fields[0];
                    int age = Integer.parseInt(fields[1]);
                    String email = fields[2];

                    Customer customer = new Customer(name, age, email);
                    customers.add(customer);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
        return customers;
    }

    // Method to serialize a list of Customer objects to a file
    public void serializeCustomers(List<Customer> customers, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            out.writeObject(customers);
        } catch (IOException e) {
            System.err.println("Error serializing objects: " + e.getMessage());
        }
    }

    // Method to deserialize the list of Customer objects from a file
    public List<Customer> deserializeCustomers(String fileName) {
        List<Customer> customers = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            customers = (List<Customer>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing objects: " + e.getMessage());
        }
        return customers;
    }
}

