package com.company;

import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException {
        CsvParser testCsv = new CsvParser("src/main/resources/SEOExample.csv");
        testCsv.printCsv();
    }
}
