package com.company;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    private List fileRows = new ArrayList();

    public CsvParser(String infile) throws IOException, CsvValidationException {
        if(checkFile(infile)) {
            readCsv(infile);
        }
    }

    protected void readCsv(String csvInfile) throws CsvValidationException, IOException {
        FileInputStream csvStream = new FileInputStream(csvInfile);
        InputStreamReader inputStream = new InputStreamReader(csvStream, StandardCharsets.UTF_8);
        CSVReader reader = new CSVReader(inputStream);

        String[] nextLine;
        while((nextLine = reader.readNext()) != null) {
            fileRows.add(nextLine);
        }
    }

    protected void printCsv() {
        for (Object row : fileRows) {
            for (String fields : (String[]) row) {
                System.out.print(fields + ", ");
            }
            System.out.println("\b\b\n---------------------");
        }
    }

    private boolean checkFile(String csvFile) {
        if(!Files.exists(Paths.get(csvFile))) {
            System.out.println("File does not exist!");
            return false;
        }
        return true;
    }
}
