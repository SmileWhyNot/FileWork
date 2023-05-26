package WorkWithFiles;

import WorkWithStrings.RusEngEnter;
import java.io.*;


public class FileOperations {
    public static RandomAccessFile file;
    public static void OpenFile_RWMODE() throws IOException {
        try {
            BufferedReader in = RusEngEnter.WorkWithString();
            System.out.println("������� ��� �����:");
            String filename = in.readLine();//���� ��� �����, ������� ������� ������� �������� ����������, �������� text.txt
            file = new RandomAccessFile(new File(filename), "rw");//�������� ����� � �������� ������
        }
        catch (Exception ex) { throw new FileNotFoundException("���� ���������� �������/�����"); }
    }
    public static String ScanText() throws IOException {
        BufferedReader in = RusEngEnter.WorkWithString();
        System.out.println("������� �����:");
        return in.readLine();
    }
    public static void TextIntoFile() throws IOException {
        try {
            String data = ScanText();
            OpenFile_RWMODE();
            file.writeBytes(data);//������ ������ � �������� ����
            System.out.println("��� ����� ��������.");
        }
        catch (Exception ex) {throw new FileNotFoundException("�� ������� �������� ������ � ����");}
        finally {
            file.close();
        }
    }
    public static void AddToTop() throws IOException{
        try {
            OpenFile_RWMODE();
            String data = file.readLine();//������ ���������� �� ��������� �����
            String s = ScanText() + " ";
            file.seek(0);//������� � ������ �����
            file.writeBytes(s);//������ ��������� ������
            file.seek(s.length());//������� � ����� ���������� ������
            file.writeBytes(data);//������ ��������� ������ ����� ��������� ������
            System.out.println("C����� �������� � ������ �����.");
        }
        catch (Exception ex) {throw new FileNotFoundException("�� ������� �������� ������ � ����");}
        finally {
            file.close();
        }
    }
    public static void AddToEnd() throws IOException{
        try{
            OpenFile_RWMODE();
            String s = " " + ScanText();
            file.seek(file.length());
            file.writeBytes(s);
            System.out.println("C����� �������� � ����� �����.");
        }
        catch (Exception ex){throw new FileNotFoundException("�� ������� �������� ������ � ����");}
        finally {
            file.close();
        }

    }
    public static void AddRandom() throws IOException {//����� ���������� ������ � ��������� ������� � �����
        try{
            BufferedReader in = RusEngEnter.WorkWithString();
            OpenFile_RWMODE();
            String s = ScanText() + " ";
            System.out.println("������� ����������� ������� � �����:");
            int n;
            n = Integer.parseInt(in.readLine());//���� �������
            file.seek(n);//�������� �� n ������� � �����
            String data = file.readLine();//������ ����� ������� � ������� n
            file.seek(n);
            file.writeBytes(s);//������ ��������� ������ � ������� n
            file.writeBytes(data);//������ ������������ � ������� n ������ ����� ��������� ������
            System.out.println("C����� �������� � ����.");
        }
        catch (Exception ex) {throw new FileNotFoundException("�� ������� �������� ������ � ����"); }
        finally {
            file.close();
        }
    }
    public static void TextFromFile() throws IOException {//����� ������ ������ �� �����
        try {
            OpenFile_RWMODE();
            String data = file.readLine();//������ ���������� �� ��������� �����
            System.out.println("���������� �� �����: " + data);//����� ���������� �� �����
        }
        catch (Exception ex) {throw new FileNotFoundException("�� ������� �������� ���������� �� �����."); }
        finally {
            file.close();
        }
    }
    public static void BinaryEnterFile() throws IOException {
        try {
            OpenFile_RWMODE();
            String data = file.readLine();//������ ���������� �� ��������� �����
            try{
                FileOutputStream fos = new FileOutputStream("Binary");
                fos.write(data.getBytes());
                fos.close();
                System.out.println("��������� ���� ������� � �������� ����");
            }
            catch (Exception ex ) {throw new FileNotFoundException("�� ������� �������� � �������� ����"); }
        }
        catch (Exception ex) {throw new FileNotFoundException("�� ������� �������� ���������� �� �����."); }
        finally {
            file.close();
        }
    }
    public static void TextIntoBinary() throws IOException{
        try{
            OpenFile_RWMODE();
            String data = file.readLine();//������ ���������� �� ��������� �����
            try {
                FileOutputStream outputStream = new FileOutputStream("BinaryResult.ser"); // ���������� ������ � ����
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); // ����������� ������� � �����
                objectOutputStream.writeObject(data);
                objectOutputStream.close();
                System.out.println("���������� ������� �������� � �������� ����");
            }
            catch (Exception ex) {throw new FileNotFoundException("�� ������� �������� � �������� ����"); }
        }
        catch (Exception ex) {throw new FileNotFoundException("�� ������� ������� ��������� ����"); }
        finally {
            file.close();
        }
    }
}