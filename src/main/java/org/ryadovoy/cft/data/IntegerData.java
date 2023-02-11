package org.ryadovoy.cft.data;

public class IntegerData implements InputData {

    private final int value;

    public IntegerData(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(InputData o) {
        return Integer.compare(value, o.getValue());
    }
}
