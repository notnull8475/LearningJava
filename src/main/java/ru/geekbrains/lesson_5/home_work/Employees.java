package ru.geekbrains.lesson_5.home_work;

public class Employees {
    private String lastname;
    private String firstname;
    private String patro;
    private String position;
    private String email;
    private String phone;
    private int solary;
    private int age;

    public Employees(
            String lastname,
            String firstname,
            String patro,
            String position,
            String email,
            String phone,
            int solary,
            int age
    ) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.patro = patro;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.solary = solary;
        this.age = age;

    }

    public void info() {
        System.out.println("ФИО: " + lastname + " " + firstname + " " + patro + "\n" +
                "Должность: " + position + "\n" +
                "Email: " + email + "\n" +
                "Телефон: " + phone + "\n" +
                "Зарплата: " + solary + "\n" +
                "Возраст: " + age);
    }


    public int getAge() {
        return age;
    }
}
