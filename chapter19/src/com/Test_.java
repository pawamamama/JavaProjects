package com;

/**
 * Class: Test_
 *
 * <pre>
 * </pre>
 *
 * @author pawamamama
 * @date 2026/8/6
 */
@SuppressWarnings({"all"})
public class Test_ {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader = new BufferedReader_(new FileReader_());
        bufferedReader.readFile();
        bufferedReader.readFiles(10);
        BufferedReader_ bufferedReader1 = new BufferedReader_(new StringReader_());
        bufferedReader1.readString();
        bufferedReader1.readStrings(10);
    }

}