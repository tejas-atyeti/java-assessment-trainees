package pojo;

import com.opencsv.bean.CsvBindByName;

public class NamedColumnBean {

    @CsvBindByName(column = "name")
    private String name;

    // Automatically infer column name as 'Age'
    @CsvBindByName
    private int age;

    @CsvBindByName(column = "email")
    private String email;

    // getters and setters
}