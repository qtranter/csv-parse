package com.company;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException, SQLException {
        CsvParser testCsv = new CsvParser("src/Data/SEOExample.csv");
        testCsv.printCsv();

        //Load the json
        Gson gson = new Gson();
        JsonReader jread = new JsonReader(new FileReader("src/Data/authors.json"));
        AuthorParser[] authors = gson.fromJson(jread, AuthorParser[].class);

        //Parse json
        for (var element: authors) {
            System.out.println(element.getName());
        }

        //Database instance
        DatabaseManager test = new DatabaseManager();

        //Insert into database for every element in json
        for (var element: authors) {
            test.insertAuthor(element.getName(), element.getEmail(), element.getURL());
        }
    }
}
