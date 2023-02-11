package org.ryadovoy.cft.data;

public interface InputData {
    <T> T getValue();
    int compareTo(InputData o);
}
