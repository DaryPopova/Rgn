package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

public class MakerFromCsvFieldsToJavaFields {

    public static void main(String args[]) throws IOException {
        String inputPath = "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\personaccount.csv";
        String outputPath = "C:\\Users\\padre\\Dropbox\\edu\\Rgn\\src\\main\\resources\\variables.txt";
        makeFromCsvFieldsToJavaFields(inputPath, outputPath);
    }

    public static void makeFromCsvFieldsToJavaFields(String inputPath, String outputPath) throws IOException {
        FileInputStream inputStream = new FileInputStream(inputPath);
        Reader in = new InputStreamReader(inputStream);
        Writer out = new FileWriter(outputPath);

        CSVParser parser = new CSVParser(in, CSVFormat.RFC4180);
        List<CSVRecord> csvRecords = parser.getRecords();
        for (int i = 0; i < csvRecords.get(0).size(); i++) {
            out.append(String.format("@Column(name = \"%s\")", csvRecords.get(0).get(i)));
            out.append("\n");
            out.append(String.format("public String %s;", csvNameToJavaName(csvRecords.get(0).get(i))));
            out.append("\n");
            out.append("");
            out.append("\n");
        }
        out.close();
    }

    public static String csvNameToJavaName(String csvName) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] csvNameStrings = csvName.split("_+");
        for (int i = 1; i < csvNameStrings.length; i++) {
            csvNameStrings[i] = csvNameStrings[i].substring(0, 1).toUpperCase() + csvNameStrings[i].substring(1);
        }
        for (int i = 0; i < csvNameStrings.length; i++) {
            stringBuilder.append(csvNameStrings[i]);
        }
        return stringBuilder.toString();
    }
}
