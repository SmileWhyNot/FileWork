package Menus;

import WorkWithFiles.*;
import WorkWithStrings.*;
import java.io.*;
public class PrintMenus {
    public static void PersonsChoice() throws IOException {
        while (true) {
            BufferedReader in = RusEngEnter.WorkWithString();
            PrintMainMenu();//����� ������ ������ ���� �� �����
            String choice = in.readLine();//���� ���������� ������ ����
            if (choice.compareTo("1") == 0) {//��������� ���������� ������������� ������ ����
                FileOperations.TextIntoFile();//����� ������ ����� ������ � ������ ��� � ����
            } else if (choice.compareTo("2") == 0) {
                PrintRedactMenu();//����� ������ ������ ��������� �������� �������������� ������ �� �����
                String choice2 = in.readLine();//���� ���������� ������
                if (choice2.compareTo("1") == 0) {
                    FileOperations.AddToTop();//����� ������ ���������� ������ � ������ �����
                } else if (choice2.compareTo("2") == 0) {
                    FileOperations.AddToEnd();//����� ������ ���������� ������ � ����� �����
                } else if (choice2.compareTo("3") == 0) {
                    FileOperations.AddRandom();//����� ������ ���������� ������ � �������� ������� � �����
                }
                else if (choice2.compareTo("4") == 0){
                    ChangeWords.OddEvenExchange();
                }
            } else if (choice.compareTo("3") == 0) {
                FileOperations.TextFromFile();//����� ������ ������ ������ �� ����� � ����������� ���������� �������, �������� � ������ ���������� ����
            } else if (choice.compareTo("4") == 0){
                FileOperations.TextIntoBinary();
            } else if (choice.compareTo("5") == 0) {
                return;//����� �� ���������
            }
        }
    }
    public static void PrintMainMenu() {//����� ������ ���� �� �����
        System.out.println("������� ��� �����:");
        System.out.println("1.������ ����� � �������� ��� � ����");
        System.out.println("2.������������� ����� � �����");
        System.out.println("3.��������� �����");
        System.out.println("4.�������� ����� � �������� ����");
        System.out.println("5.�����");
    }
    public static void PrintRedactMenu() {//����� ������ ��������� �������� �������������� ������ �� �����
        System.out.println("�������� ��������:");
        System.out.println("1 - ���������� ������ � ������ �����");
        System.out.println("2 - ���������� ������ � ����� �����");
        System.out.println("3 - ���������� ������ � ������������ ������� � �����");
        System.out.println("4 - �������� ������ � �������� ����� �������");
    }
}