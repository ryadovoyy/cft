# cft

This is a program for sorting several files with the merge sort algorithm. The input files contain data of one of two types: integers or strings. The data is written in columns (each line of a file is a new item). Strings can contain any non-whitespace characters. It is also assumed that the files are pre-sorted.

The result should be a new file with the combined contents of the input files, sorted in ascending or descending order.

## Requirements

- Oracle OpenJDK 19.0.2
- Maven 3.8.1

## Launch instructions

### Build

```bash
git clone https://github.com/ryadovoyy/cft.git
cd cft
mvn package
```

### Usage

```
Usage:
  java -jar target/cft-1.0-SNAPSHOT.jar [-a | -d] (-s | -i) <output-file> <input-file>...

Options:
  -a  Ascending sort mode (default)
  -d  Descending sort mode
  -s  String data type
  -i  Interger data type

Arguments:
  <output-file>    Output file name
  <input-file>...  Input file names
```

Example for integers in descending order:

```bash
java -jar target/cft-1.0-SNAPSHOT.jar -d -i out.txt in1.txt in2.txt
```
