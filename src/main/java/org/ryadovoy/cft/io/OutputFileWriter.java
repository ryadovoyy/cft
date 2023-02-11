package org.ryadovoy.cft.io;

import org.ryadovoy.cft.data.InputData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputFileWriter {

    public static void writeData(List<InputData> data, String fileName) throws IOException {
        List<String> lines = new ArrayList<>();

        for (InputData inputData : data) {
            lines.add(inputData.getValue().toString());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Error writing to file " + fileName + ": " + e.getMessage());
        }
    }
}
