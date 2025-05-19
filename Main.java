package com.company;

import java.util.Scanner;

interface User {
    void setLogin(String login);
    void setPassword(String password);
    String getLogin();
    boolean checkPassword(String password);
}

abstract class People implements User {
    protected String fullName;
    protected int age;
    protected String position;
    private String login;
    private String password;

    public People(String fullName, int age, String position) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName + ", Возраст: " + age + ", Должность: " + position);
    }
}

class Teacher extends People {
    public Teacher(String fullName, int age) {
        super(fullName, age, "Преподаватель");
    }
}

class Student extends People {
    public Student(String fullName, int age) {
        super(fullName, age, "Студент");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        People[] people = new People[4];

        System.out.println("Введите данные для 2 преподавателей:");
        for (int i = 0; i < 2; i++) {
            System.out.print("ФИО: ");
            String name = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Логин: ");
            String login = scanner.nextLine();

            System.out.print("Пароль: ");
            String password = scanner.nextLine();

            Teacher teacher = new Teacher(name, age);
            teacher.setLogin(login);
            teacher.setPassword(password);
            people[i] = teacher;

            System.out.println();
        }

        System.out.println("Введите данные для 2 студентов:");
        for (int i = 2; i < 4; i++) {
            System.out.print("ФИО: ");
            String name = scanner.nextLine();

            System.out.print("Возраст: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Логин: ");
            String login = scanner.nextLine();

            System.out.print("Пароль: ");
            String password = scanner.nextLine();

            Student student = new Student(name, age);
            student.setLogin(login);
            student.setPassword(password);
            people[i] = student;

            System.out.println();
        }

        System.out.println("Список всех пользователей:");
        for (People person : people) {
            person.printInfo();
            System.out.println("Логин: " + person.getLogin());
            System.out.println();
        }

        System.out.print("Проверка пароля — введите логин: ");
        String inputLogin = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String inputPassword = scanner.nextLine();

        boolean found = false;
        for (People person : people) {
            if (person.getLogin().equals(inputLogin)) {
                if (person.checkPassword(inputPassword)) {
                    System.out.println("Пароль верный. Добро пожаловать, " + person.fullName);
                } else {
                    System.out.println("Неверный пароль.");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Пользователь с таким логином не найден.");
        }
    }
}