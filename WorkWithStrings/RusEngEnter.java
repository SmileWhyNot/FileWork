package WorkWithStrings;

import java.io.*;
public class RusEngEnter {
    public static BufferedReader WorkWithString() throws UnsupportedEncodingException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "Cp1251"));//�������� ������� ������ BufferedReader � ������������ ����� ������ �� ������� �����(��������� "Cp1251")
        return in;
    }
}