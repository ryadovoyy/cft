package org.ryadovoy.cft;

import org.ryadovoy.cft.data.DataParser;
import org.ryadovoy.cft.data.InputData;
import org.ryadovoy.cft.data.IntegerDataParser;
import org.ryadovoy.cft.data.StringDataParser;
import org.ryadovoy.cft.io.CommandLineParser;
import org.ryadovoy.cft.io.InputFileReader;
import org.ryadovoy.cft.io.OutputFileWriter;
import org.ryadovoy.cft.sort.MergeSorter;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            CommandLineParser commandLineParser = new CommandLineParser(args);

            DataParser dataParser = null;
            switch (commandLineParser.getDataType()) {
                case STRING:
                    dataParser = new StringDataParser();
                    break;
                case INTEGER:
                    dataParser = new IntegerDataParser();
                    break;
            }

            InputFileReader inputFileReader = new InputFileReader(dataParser);
            MergeSorter mergeSorter = new MergeSorter(inputFileReader, commandLineParser.getSortMode());

            List<InputData> result = mergeSorter.sort(commandLineParser.getInputFiles());
            OutputFileWriter.writeData(result, commandLineParser.getOutputFile());
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
