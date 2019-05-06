package readers;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;

public class CSVMappedToJavaBean {
    public static void main(String[] args) throws Exception
    {
        new Employee().readCsvToObject("C:\\Users\\padre\\Downloads\\part-00000-82627f3f-3dc5-4248-b2c8-a3be01166c22-c000.csv");
    }


}