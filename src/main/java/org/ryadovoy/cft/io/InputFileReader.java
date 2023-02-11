package org.ryadovoy.cft.io;

import org.ryadovoy.cft.data.DataParser;
import org.ryadovoy.cft.data.InputData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

    private final DataParser dataParser;

    public InputFileReader(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    public List<InputData> readFile(String fileName) throws IOException {
        List<InputData> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                InputData data = dataParser.parseLine(line);
                if (data != null) {
                    result.add(data);
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading file " + fileName + ": " + e.getMessage());
        }

        return result;
    }
}
