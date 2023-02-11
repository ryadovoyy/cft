package org.ryadovoy.cft.data;

public class StringDataParser implements DataParser {

    @Override
    public StringData parseLine(String line) {
        if (!line.contains(" ") && line.length() > 0) {
            return new StringData(line);
        }
        System.out.println("Invalid string data in line: " + line);
        return null;
    }
}
