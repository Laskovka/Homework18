package ua.com.alevel.Serialization;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class UserImpl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какую команду вы хотите выполнить? \"create\" или \"show\"?");
        while (true) {
            String command = scanner.nextLine().trim();
            if (command.equals("create")) {
                createUser();
                break;
            } else if (command.equals("show")) {
                showUser();
                break;
            } else {
                System.out.println("Неверная команда.");
            }
        }
    }

    public static void createUser() {
        Scanner createUserScanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя.");
        String createUserName = createUserScanner.nextLine().trim();
        System.out.println("Введите почту пользователя.");
        String createEmail = createUserScanner.nextLine().trim();
        System.out.println("Введите номер телефона пользователя.");
        String createPhoneNumber = createUserScanner.nextLine().trim();

        User user = new User(createUserName, createEmail, createPhoneNumber);

        String userDatFile = createUserName.toUpperCase(Locale.ROOT).replace(" ", "_") + ".dat";
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/" + userDatFile, false);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(user);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void showUser() {
        Scanner showUserScanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя, информацию которого вы хотите получить.");
        String showUserName = showUserScanner.nextLine().trim();
        String showUserNameForDatFile = showUserName.toUpperCase(Locale.ROOT).replace(" ", "_") + ".dat";
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/" + showUserNameForDatFile);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            User user = (User) objectInputStream.readObject();
            System.out.println(user.toString());
        } catch (IOException | ClassNotFoundException fileNotFoundException) {
            System.out.println("User \"" + showUserName + "\" не найден.");
        }
    }
}
