package models;

import java.util.ArrayList;
import java.util.Arrays;

public class Report {
    public ArrayList<String> lines = new ArrayList<>();
    private int currentIndent = 0;

    public Report(int indent) {
        currentIndent = indent;
    }

    public Report() {

    }

    public void addLine(int indent, String template, String... formatParameters) {
        char[] indentSpaces = new char[indent * 2];
        Arrays.fill(indentSpaces, ' ');
        lines.add(new String(indentSpaces) + String.format(template, formatParameters));
    }

    public void addLine(String template, String... formatParameters) {
        addLine(currentIndent, template, formatParameters);
    }

    public void indent() { currentIndent++; }

    public void unindent() {
        currentIndent--;
        if (currentIndent < 0)
            currentIndent = 0;
    }

    @Override
    public String toString() {
        return String.join("\n", lines);
    }
}
