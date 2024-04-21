package org.example;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Hammer> rawHammers = new ArrayList<>();
    public static ArrayList<Hammer> packedHammers = new ArrayList<>();

    public static Work[] works = {
            new Work("Собирать молотки"),
            new Work("Пилить ручки"),
            new Work("Делать бойки"),
            new Work("Упаковывать молотки")
    };

    public static Employee[] employees = {
            new Employee("Ходжахов Эмиль"),
            new Employee("Лысенко Семён"),
            new Employee("Солнцев Гоген")
    };

    public static void main(String[] args) {
        int index;
        boolean isRunning = true;

        String[] functionNames = {
                "Статус завода",
                "Взять работу",
                "Взять работника",
                "Получить упакованный молоток",
                "Получить неупакованный молоток",
                "Добавить молоток",
                "Упаковать молоток"
        };

        while (isRunning) {
            int num = 1;

            System.out.println("Выберите действие на заводе:");
            System.out.println("0. Выйти из программы");

            for (String functionName : functionNames) {
                System.out.println(num + ". " + functionName);
                num++;
            }

            int choice = scanner.nextInt();

            if (choice == 1) factoryStatus();
            else if (choice == 2) {
                String output = getWork();
                System.out.println(output);
            }
            else if (choice == 3) {
                String output = getRandomEmployee();
                System.out.println(output);
            }
            else if (choice == 4) {
                String output = getPackedHammer();
                System.out.println(output);
            }
            else if (choice == 5) {
                String output = getRawHammer();
                System.out.println(output);
            }
            else if (choice == 6) {
                System.out.println("Выберете молоток: ");
                index = scanner.nextInt();
                addHammers(index);
                String output = "Молоток " + index + " добавлен";
                System.out.println(output);
            }
            else if (choice == 7) {
                System.out.println("Выберете молоток: ");
                index = scanner.nextInt();
                sealHammer(index);
                String output = "Молоток " + index + " упакован";
                System.out.println(output);
            }
            else if (choice == 0) {
                System.out.println("Удачного вам дня!");
                isRunning = false;
            }
            else {
                System.out.println("Некорректный ввод");
            }
        }
    }

    public static void factoryStatus() {
        int hours = Integer.parseInt(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()));

        if(hours < 8 || hours > 22) {
            System.out.println("Завод закрыт! Приходите завтра");
        }
        else {
            System.out.println("Рабочие работают, завод работает!");
        }
    }

    public static String getWork() {
        return works[new Random().nextInt(works.length)].getTask();
    }

    public static String getRandomEmployee() {
        return employees[new Random().nextInt(employees.length)].getName();
    }

    public static String getPackedHammer() {
        int index = new Random().nextInt(packedHammers.size());
        return packedHammers.get(index).getHammer();
    }

    public static String getRawHammer() {
        int index = new Random().nextInt(rawHammers.size());
        return rawHammers.get(index).getHammer();
    }

    public static void addHammers(int index) {
        for (int i = 1; i < index; i++) {
            rawHammers.add(new Hammer("МОЛОТОК " + i));
        }
    }

    public static void sealHammer(int index) {
        Hammer hammer = rawHammers.get(index);
        packedHammers.add(hammer);
        rawHammers.remove(index);
    }
}
