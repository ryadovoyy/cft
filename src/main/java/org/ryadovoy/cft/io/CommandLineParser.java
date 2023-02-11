package org.ryadovoy.cft.io;

import org.ryadovoy.cft.data.DataType;
import org.ryadovoy.cft.sort.SortMode;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class CommandLineParser {

    private SortMode sortMode = SortMode.ASCENDING;
    private DataType dataType;
    private String outputFile;
    private final List<String> inputFiles = new ArrayList<>();

    public CommandLineParser(String[] args) throws IllegalArgumentException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Error: Invalid number of arguments. Required: data type, output file name, input file names (at least one)");
        }

        for (String arg : args) {
            switch (arg) {
                case "-a":
                    sortMode = SortMode.ASCENDING;
                    break;
                case "-d":
                    sortMode = SortMode.DESCENDING;
                    break;
                case "-s":
                    dataType = DataType.STRING;
                    break;
                case "-i":
                    dataType = DataType.INTEGER;
                    break;
                default:
                    if (arg.matches("-.*")) {
                        throw new IllegalArgumentException("Error: Invalid argument: " + arg);
                    } else if (outputFile == null) {
                        outputFile = arg;
                    } else if (Objects.equals(arg, outputFile)) {
                        throw new IllegalArgumentException("Error: Input and output file names must be different");
                    } else {
                        inputFiles.add(arg);
                    }
            }
        }

        if (dataType == null) {
            throw new IllegalArgumentException("Error: Data type is required (use -s for strings or -i for integers)");
        }
        if (outputFile == null) {
            throw new IllegalArgumentException("Error: Output file name is required");
        }
        if (inputFiles.isEmpty()) {
            throw new IllegalArgumentException("Error: At least one input file is required");
        }
    }

    public SortMode getSortMode() {
        return sortMode;
    }

    public DataType getDataType() {
        return dataType;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public List<String> getInputFiles() {
        return inputFiles;
    }
}
