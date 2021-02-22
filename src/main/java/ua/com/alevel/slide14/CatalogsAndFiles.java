package ua.com.alevel.slide14;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CatalogsAndFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Laskovskiu\\IdeaProjects\\Homework18");
        List<File> files = new LinkedList<>(Arrays.asList(file.listFiles()));
        files.sort((left, right) -> {
            if (left.isFile() && right.isDirectory()) {
                return 1;
            } else if (right.isFile() && left.isDirectory()) {
                return -1;
            }
            return left.getName().compareTo(right.getName());
        });

        List<String> receivedList = new LinkedList<>(recursiveMethod(files, ""));
        receivedList.forEach(string -> System.out.println(string));
    }

    public static List<String> recursiveMethod(List<File> files, String countOfSpaces) {
        List<String> finalStringListOfFiles = new LinkedList<>();
        String tempCountOfSpaces = countOfSpaces + " ";
        for (int i = 0; i < files.size(); i++) {
            if(files.get(i).isDirectory()) {
                finalStringListOfFiles.add(countOfSpaces + "*" + files.get(i).getName());
                List<File> tempListOfFiles = new LinkedList<>(Arrays.asList(files.get(i).listFiles()));
                finalStringListOfFiles.addAll(recursiveMethod(tempListOfFiles, tempCountOfSpaces));
            } else if(files.get(i).isFile()) {
                finalStringListOfFiles.add(countOfSpaces + files.get(i).getName());
            }
        }
        return finalStringListOfFiles;
    }
}
