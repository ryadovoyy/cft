package org.ryadovoy.cft.data;

public class StringData implements InputData {

    private final String value;

    public StringData(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(InputData o) {
        return value.compareTo(o.getValue());
    }
}
