package Menus;

import WorkWithFiles.*;
import WorkWithStrings.*;
import java.io.*;
public class PrintMenus {
    public static void PersonsChoice() throws IOException {
        while (true) {
            BufferedReader in = RusEngEnter.WorkWithString();
            PrintMainMenu();//вызов метода вывода меню на экран
            String choice = in.readLine();//ввод выбранного пункта меню
            if (choice.compareTo("1") == 0) {//сравнение выбранного пользователем пункта меню
                FileOperations.TextIntoFile();//вызов метода ввода текста и записи его в файл
            } else if (choice.compareTo("2") == 0) {
                PrintRedactMenu();//вызов метода вывода возможных действий редактирования текста на экран
                String choice2 = in.readLine();//ввод выбранного пункта
                if (choice2.compareTo("1") == 0) {
                    FileOperations.AddToTop();//вызов метода добавления текста в начало файла
                } else if (choice2.compareTo("2") == 0) {
                    FileOperations.AddToEnd();//вызов метода добавления текста в конец файла
                } else if (choice2.compareTo("3") == 0) {
                    FileOperations.AddRandom();//вызов метода добавления текста в указаную позицию в файле
                }
                else if (choice2.compareTo("4") == 0){
                    ChangeWords.OddEvenExchange();
                }
            } else if (choice.compareTo("3") == 0) {
                FileOperations.TextFromFile();//вызов метода чтения текста из файла и определение количества гласных, пробелов и общего количества букв
            } else if (choice.compareTo("4") == 0){
                FileOperations.TextIntoBinary();
            } else if (choice.compareTo("5") == 0) {
                return;//выход из программы
            }
        }
    }
    public static void PrintMainMenu() {//метод вывода меню на экран
        System.out.println("Введите ваш выбор:");
        System.out.println("1.Ввести текст и записать его в файл");
        System.out.println("2.Редактировать текст в файле");
        System.out.println("3.Прочитать текст");
        System.out.println("4.Записать текст в бинарный файл");
        System.out.println("5.Выход");
    }
    public static void PrintRedactMenu() {//метод вывода возможных действий редактирования текста на экран
        System.out.println("Выберите действие:");
        System.out.println("1 - добавление текста в начало файла");
        System.out.println("2 - добавление текста в конец файла");
        System.out.println("3 - добавление текста в произвольную позицию в файле");
        System.out.println("4 - поменять четные и нечетные слова местами");
    }
}