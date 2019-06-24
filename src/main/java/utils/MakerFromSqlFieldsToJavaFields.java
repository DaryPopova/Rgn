package utils;

import database.DatabaseReader;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MakerFromSqlFieldsToJavaFields {
    public static void main(String args[]) throws Exception {
        makeFromCsvFieldsToJavaFields("semarchy_dloc2.gd_org_ext_identifier", "/home/alex/IdeaProjects/Rgn/src/main/variables.txt");
    }

    public static void makeFromCsvFieldsToJavaFields(String sqlTable, String outputPath) throws Exception {
        Writer out = new FileWriter(outputPath);
        DatabaseReader databaseReader = new DatabaseReader();
        Connection connection = databaseReader.createConnection("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
        PreparedStatement pst = connection.prepareStatement(String.format("SELECT * FROM %s", sqlTable));
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            out.append(String.format("@Column(name = \"%s\")", rsmd.getColumnName(i)));
            out.append("\n");
            out.append(String.format("public String %s;", sqlNameToJavaName(rsmd.getColumnName(i))));
            out.append("\n");
            out.append("");
            out.append("\n");
        }
        out.close();
    }

    public static String sqlNameToJavaName(String csvName) {
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