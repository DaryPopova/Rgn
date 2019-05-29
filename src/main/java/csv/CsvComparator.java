package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;

public class CsvComparator {
    public void compareCsvFiles(String inputPath, String outPath, String diffPath) throws IOException {
        FileInputStream inputFile = new FileInputStream(inputPath);
        FileInputStream outputFile = new FileInputStream(outPath);
        Reader in = new InputStreamReader(inputFile);
        Reader out = new InputStreamReader(outputFile);

        CSVParser inParser = new CSVParser(in, CSVFormat.RFC4180);
        CSVParser outParser = new CSVParser(out, CSVFormat.RFC4180);
        List<CSVRecord> inCsvRecords = inParser.getRecords();
        List<CSVRecord> outCsvRecords = outParser.getRecords();
        FileWriter writer = new FileWriter(new File(diffPath));

        Integer minSizeOfOuterList = Math.min(inCsvRecords.size() - 1, outCsvRecords.size());

        for (int i = 1; i < minSizeOfOuterList; i++) {
            Integer minSizeOfInnerList = Math.min(inCsvRecords.get(i).size(), outCsvRecords.get(i).size());
            for (int j = 0; j < minSizeOfInnerList; j++) {
                Object expected = getCell(inCsvRecords, i , j);
                Object actual = getCell(outCsvRecords, i - 1 , j);
                if (!expected.equals(actual)) {
                    writer.append(String.format("Строка: %s Столбец: %s in(exp): %s out(act) %s",
                            i - 1, j, expected, actual));
                    writer.append("\n");
                }
            }
        }
        writer.close();
    }

    public Object getCell(List<CSVRecord> cells, int i, int j) {
        if (cells.get(i).get(j) == null) {
            return "";
        } else return cells.get(i).get(j);
    }
}