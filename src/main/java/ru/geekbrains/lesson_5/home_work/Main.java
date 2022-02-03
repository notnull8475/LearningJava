package ru.geekbrains.lesson_5.home_work;

public class Main {

    public static void main(String[] args) {
        Employees[] employeesArray = new Employees[5];
        employeesArray[0] = new Employees("Ivanov",
                "Ivan",
                "Ivanovich",
                "Programmer",
                "mail@mail.ru",
                "89123456789",
                100000,
                30);
        employeesArray[1] = new Employees("Alekseev",
                "Aleksey",
                "Alekseevich",
                "Engineer",
                "mail1@mail.ru",
                "89123456789",
                100000,
                43);
        employeesArray[2] = new Employees("Petrov",
                "Petr",
                "Petrovich",
                "Operator",
                "mail2@mail.ru",
                "89123456789",
                100000,
                45);
        employeesArray[3] = new Employees("Malov",
                "Fedor",
                "Fedorovich",
                "Driver",
                "mail3@mail.ru",
                "89123456789",
                100000,
                25);
        employeesArray[4] = new Employees("Krylov",
                "Valentin",
                "Arturovich",
                "Administrator",
                "mail4@mail.ru",
                "89123456789",
                100000,
                41);


        for (Employees e : employeesArray) {
            if (e.getAge() > 40) {
                e.info();
                System.out.println();
            }
        }

    }


}
