package nhs.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for reading CSV data files.
 * Handles file reading operations and returns data as string arrays.
 */
public class CSVFileReader {

    /**
     * Reads a CSV file and returns all data rows (excluding header).
     * 
     * @param filePath the path to the CSV file
     * @return list of string arrays, each representing a data row
     */
    public static List<String[]> readDataFromCSV(String filePath) {
        List<String[]> dataRows = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;

            // Skip the header row
            fileReader.readLine();

            // Read all data rows
            while ((currentLine = fileReader.readLine()) != null) {
                if (!currentLine.trim().isEmpty()) {
                    String[] columnValues = currentLine.split(",");
                    dataRows.add(columnValues);
                }
            }

        } catch (IOException fileException) {
            System.err.println("Failed to read CSV file: " + filePath);
            fileException.printStackTrace();
        }

        return dataRows;
    }
}
