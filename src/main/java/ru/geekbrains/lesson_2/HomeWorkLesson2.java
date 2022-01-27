package ru.geekbrains.lesson_2;

public class HomeWorkLesson2 {
    public static void main(String[] args) {
        int a = 9, b = 89;

        System.out.println("Сумма чисел" + (sum(a, b) ? " в диапазоне [10:20]" : " вне диапазона [10:20]"));
        positiveNumberPrint(a);
        System.out.println("Число отрицательное - " + positiveNumber(a));
        stringPrint("Hello World!", 10);
        System.out.println(leapYear(2000) ? "високосный" : "не високосный");
        System.out.println(leapYear(2001) ? "високосный" : "не високосный");

    }

    /*
    * 1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
        в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    * */

    public static boolean sum(int a, int b) {
        return a + b > 10 && a + b <= 20;
    }

    /*
    * 2. Написать метод, которому в качестве параметра передается целое число, метод должен
        напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль
        считаем положительным числом.
    * */
    public static void positiveNumberPrint(int a) {
        if (positiveNumber(a)) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    /*
    * 3. Написать метод, которому в качестве параметра передается целое число. Метод должен
        вернуть true, если число отрицательное, и вернуть false если положительное.
    * */
    public static boolean positiveNumber(int a) {
        return a < 0;
    }

    /*
    * 4. Написать метод, которому в качестве аргументов передается строка и число, метод должен
        отпечатать в консоль указанную строку, указанное количество раз;
    * */
    public static void stringPrint(String string, int numb) {
        for (int i = 0; i < numb; i++) {
            System.out.println(string);
        }
    }

    /*
    5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean
    (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого
    100-го, при этом каждый 400-й – високосный.
    */
    public static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
