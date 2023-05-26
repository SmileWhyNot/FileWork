package WorkWithStrings;

import java.io.*;
import java.util.StringTokenizer;
import WorkWithFiles.FileOperations;
public class ChangeWords {
    public static void OddEvenExchange() throws IOException {
            FileOperations.OpenFile_RWMODE();
            String AnalizingStr = FileOperations.file.readLine();//чтение информации из заданного файла
            StringTokenizer tokenizer = new StringTokenizer(AnalizingStr);
            int WordsCount = tokenizer.countTokens();
            String[] tokens = new String[WordsCount];
            for (int i = 0; i < WordsCount; i++) {
                tokens[i] = tokenizer.nextToken();//запись слов в массив
            }
            String[] TempStr = new String[1];
            if (WordsCount % 2 == 0){ ExChangeWords(TempStr, tokens, WordsCount); }
            else{ ExChangeWords(TempStr, tokens, WordsCount-1); }
            AnalizingStr = "";
            for (int i = 0; i < WordsCount; i++){
                AnalizingStr += tokens[i] + " ";
            }
            FileOperations.file.seek(0);
            FileOperations.file.writeBytes(AnalizingStr);//запись текста в заданный файл
            FileOperations.file.close();
    }
    public static void ExChangeWords(String[] str, String[] tokens, int n){
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                str[0] = tokens[i];
                tokens[i] = tokens[i+1];
                tokens[i+1] = str[0];
            }
        }
    }
}