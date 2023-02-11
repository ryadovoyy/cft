package org.ryadovoy.cft.data;

public class IntegerDataParser implements DataParser {

    @Override
    public IntegerData parseLine(String line) {
        try {
            int value = Integer.parseInt(line);
            return new IntegerData(value);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer data in line: " + line);
            return null;
        }
    }
}
