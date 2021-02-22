package ua.com.alevel.slide21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromConsoleAndWriteInFile {
    public static void main(String[] args) {
        String path = "src/main/resources/save.json";
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            System.out.println("Введите ключ значения.");
            fileWriter.write("{");
            workWithUser(fileWriter);
            fileWriter.write("}");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void workWithUser(FileWriter fileWriter) throws IOException {
        String finalStringForJSONFile = "";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String tempString = scanner.nextLine().trim();
            if (tempString.equals("end")) {
                break;
            }

            char[] tempStringToCharArray = tempString.toCharArray();
            for (int i = 0; i < tempStringToCharArray.length; i++) {
                if (tempStringToCharArray[i] == '=' &&
                        tempStringToCharArray[i - 1] == ' ' &&
                        tempStringToCharArray[i - 2] != ' ' &&
                        tempStringToCharArray[i + 1] == ' ' &&
                        tempStringToCharArray[i + 2] != ' ') {
                    String key = tempString.substring(0, (i - 1));
                    finalStringForJSONFile += "\"" + key + "\":";

                    String value = tempString.substring((i + 2));
                    if(transferToInteger(value)) {
                        Integer valueOfInteger = Integer.parseInt(value);
                        finalStringForJSONFile += valueOfInteger + ",";
                    } else if(transferToDouble(value)) {
                        Double valueOfDouble =  Double.parseDouble(value);
                        finalStringForJSONFile += valueOfDouble + ",";
                    } else {
                        finalStringForJSONFile += "\"" + value + "\",";
                    }
                    break;
                }
            }
        }
        finalStringForJSONFile = finalStringForJSONFile.substring(0, finalStringForJSONFile.length() - 1);
        fileWriter.write(finalStringForJSONFile);
    }

    public static boolean transferToInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static boolean transferToDouble(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
