package org.ryadovoy.cft.sort;

import org.ryadovoy.cft.data.InputData;
import org.ryadovoy.cft.io.InputFileReader;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class MergeSorter {

    private final InputFileReader inputFileReader;
    private final SortMode sortMode;

    public MergeSorter(InputFileReader inputFileReader, SortMode sortMode) {
        this.inputFileReader = inputFileReader;
        this.sortMode = sortMode;
    }

    public List<InputData> sort(List<String> inputFiles) throws IOException {
        List<InputData> result = new ArrayList<>();
        List<List<InputData>> dataLists = new ArrayList<>();

        for (String file : inputFiles) {
            try {
                List<InputData> dataList = inputFileReader.readFile(file);
                if (!isSorted(dataList)) {
                    dataList = mergeSort(dataList);
                }
                dataLists.add(dataList);
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
        }

        for (List<InputData> dataList : dataLists) {
            result = merge(result, dataList);
        }

        return result;
    }

    private List<InputData> mergeSort(List<InputData> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }

        int mid = dataList.size() / 2;
        List<InputData> left = dataList.subList(0, mid);
        List<InputData> right = dataList.subList(mid, dataList.size());

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private List<InputData> merge(List<InputData> list1, List<InputData> list2) {
        List<InputData> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            InputData data1 = list1.get(i);
            InputData data2 = list2.get(j);

            if (sortMode == SortMode.ASCENDING) {
                if (data1.compareTo(data2) <= 0) {
                    result.add(data1);
                    i++;
                } else {
                    result.add(data2);
                    j++;
                }
            } else {
                if (data1.compareTo(data2) >= 0) {
                    result.add(data1);
                    i++;
                } else {
                    result.add(data2);
                    j++;
                }
            }
        }

        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }

        return result;
    }

    private boolean isSorted(List<InputData> dataList) {
        for (int i = 0; i < dataList.size() - 1; i++) {
            InputData data1 = dataList.get(i);
            InputData data2 = dataList.get(i + 1);
            int compareResult = data1.compareTo(data2);

            if (sortMode == SortMode.ASCENDING) {
                if (compareResult > 0) {
                    return false;
                }
            } else {
                if (compareResult < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
