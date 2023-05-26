package WorkWithFiles;

import WorkWithStrings.RusEngEnter;
import java.io.*;


public class FileOperations {
    public static RandomAccessFile file;
    public static void OpenFile_RWMODE() throws IOException {
        try {
            BufferedReader in = RusEngEnter.WorkWithString();
            System.out.println("Введите имя файла:");
            String filename = in.readLine();//ввод имя файла, которое следует вводить учитывая расширение, например text.txt
            file = new RandomAccessFile(new File(filename), "rw");//создание файла с заданным именем
        }
        catch (Exception ex) { throw new FileNotFoundException("Файл невозможно создать/найти"); }
    }
    public static String ScanText() throws IOException {
        BufferedReader in = RusEngEnter.WorkWithString();
        System.out.println("Введите текст:");
        return in.readLine();
    }
    public static void TextIntoFile() throws IOException {
        try {
            String data = ScanText();
            OpenFile_RWMODE();
            file.writeBytes(data);//запись текста в заданный файл
            System.out.println("Выш текст сохранен.");
        }
        catch (Exception ex) {throw new FileNotFoundException("Не удалось записать данные в файл");}
        finally {
            file.close();
        }
    }
    public static void AddToTop() throws IOException{
        try {
            OpenFile_RWMODE();
            String data = file.readLine();//чтение информации из заданного файла
            String s = ScanText() + " ";
            file.seek(0);//переход в начало файла
            file.writeBytes(s);//запись введенной строки
            file.seek(s.length());//переход в конец записанной строки
            file.writeBytes(data);//запись исходного текста после введенной строки
            System.out.println("Cтрока записана в начало файла.");
        }
        catch (Exception ex) {throw new FileNotFoundException("Не удалось записать данные в файл");}
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
            System.out.println("Cтрока записана в конец файла.");
        }
        catch (Exception ex){throw new FileNotFoundException("Не удалось записать данные в файл");}
        finally {
            file.close();
        }

    }
    public static void AddRandom() throws IOException {//метод добавления текста в указанную позицию в файле
        try{
            BufferedReader in = RusEngEnter.WorkWithString();
            OpenFile_RWMODE();
            String s = ScanText() + " ";
            System.out.println("Введите необходимую позицию в файле:");
            int n;
            n = Integer.parseInt(in.readLine());//ввод позиции
            file.seek(n);//смещение на n позицию в файле
            String data = file.readLine();//чтение файла начиная с позиции n
            file.seek(n);
            file.writeBytes(s);//запись введенной строки с позиции n
            file.writeBytes(data);//запись прочитанного с позиции n текста после введенной строки
            System.out.println("Cтрока записана в файл.");
        }
        catch (Exception ex) {throw new FileNotFoundException("Не удалось записать данные в файл"); }
        finally {
            file.close();
        }
    }
    public static void TextFromFile() throws IOException {//метод чтения текста из файла
        try {
            OpenFile_RWMODE();
            String data = file.readLine();//чтение информации из заданного файла
            System.out.println("Информация из файла: " + data);//вывод информации из файла
        }
        catch (Exception ex) {throw new FileNotFoundException("Не удалось получить информацию из файла."); }
        finally {
            file.close();
        }
    }
    public static void BinaryEnterFile() throws IOException {
        try {
            OpenFile_RWMODE();
            String data = file.readLine();//чтение информации из заданного файла
            try{
                FileOutputStream fos = new FileOutputStream("Binary");
                fos.write(data.getBytes());
                fos.close();
                System.out.println("Текстовый файл записан в бинарный файл");
            }
            catch (Exception ex ) {throw new FileNotFoundException("Не удалось записать в бинарный файл"); }
        }
        catch (Exception ex) {throw new FileNotFoundException("Не удалось получить информацию из файла."); }
        finally {
            file.close();
        }
    }
    public static void TextIntoBinary() throws IOException{
        try{
            OpenFile_RWMODE();
            String data = file.readLine();//чтение информации из заданного файла
            try {
                FileOutputStream outputStream = new FileOutputStream("BinaryResult.ser"); // записывает данные в файл
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream); // преобразует объекты в байты
                objectOutputStream.writeObject(data);
                objectOutputStream.close();
                System.out.println("Информация успешно записана в бинарный файл");
            }
            catch (Exception ex) {throw new FileNotFoundException("Не удалось записать в бинарный файл"); }
        }
        catch (Exception ex) {throw new FileNotFoundException("Не удалось открыть текстовый файл"); }
        finally {
            file.close();
        }
    }
}