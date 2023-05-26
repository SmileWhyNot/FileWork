package WorkWithStrings;

import java.io.*;
public class RusEngEnter {
    public static BufferedReader WorkWithString() throws UnsupportedEncodingException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));//создание объекта класса BufferedReader с возможностью ввода данных на русском языке(кодировка "Cp1251")
        return in;
    }
}