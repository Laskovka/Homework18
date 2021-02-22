package ua.com.alevel.slide8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReadFileAndReturnCount {
    public static void main(String[] args) {
        String path = "src/main/resources/fileTXT.txt";
        String inputString = "";
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                inputString += (char) i;
            }
            inputString = inputString.trim();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        System.out.println("total rows amount: " + countOfRows(inputString));
        countOfWordsInRow(inputString);
    }

    public static int countOfRows(String inputString) {
        if (inputString.length() == 0) {
            return 0;
        }
        int count = 1;
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == '\\' && inputString.charAt(i + 1) == 'n') {
                count++;
            }
        }
        return count;
    }

    public static void countOfWordsInRow(String inputString) {
        ArrayList<String> alphabet = new ArrayList<>();
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < inputString.length() - 1; i++) {
            if (inputString.charAt(i) == '\\' && inputString.charAt(i + 1) == 'n') {
                endIndex = i;
                alphabet.add(inputString.substring(beginIndex, endIndex).trim());
                beginIndex = i + 2;
                i = i + 2;
            }
        }
        if(beginIndex != inputString.length()) {
            alphabet.add(inputString.substring(beginIndex).trim());
        }

        for (int i = 0; i < alphabet.size(); i++) {
            int countOfWords = 0;
            for (int j = 0; j < alphabet.get(i).length() - 1; j++) {
                if(alphabet.get(i).charAt(j) != ' ' && alphabet.get(i).charAt(j + 1) == ' ') {
                    countOfWords++;
                }
            }
            countOfWords++;
            System.out.println("row # " + (i + 1) + " has " + countOfWords + " words");
        }
    }
}
