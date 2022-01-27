package ru.geekbrains.lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkLesson3 {
    private static final Random random = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста введите длинну массива для обработки");
        int numb = scanner.nextInt();

        System.out.println("\nTask 1");
        System.out.println("передаваемый массив:");
        int[] array = new int[numb];
        for (int i = 0; i < numb; i++) {
            array[i] = random.nextInt(10)%2;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("получили:");
        System.out.println(Arrays.toString(task1(array)));

        for (int i = 0; i < numb; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("\nTask 2");
        System.out.println(Arrays.toString(task2()));

        System.out.println("\nTask 3");
        System.out.println(Arrays.toString(task3()));

        System.out.println("\nTask 4");
        task4(numb);

        System.out.println("\nTask 5");
        int x = random.nextInt(20);
        System.out.println("Передаваемые значения: task5("+numb+","+x+")");
        System.out.println(Arrays.toString(task5(numb,x)));

        System.out.println("\nTask 6");
        task6(array);

        System.out.println("\nTask 7");
        System.out.printf("%b\n",checkBalance(array));

        System.out.println("\nTask 8");

        System.out.println("введите смещение:");
        int shift = scanner.nextInt();
        scanner.close();
        System.out.println("передали массив от 1 до 100");
        System.out.println("получили");
        System.out.println(Arrays.toString(shiftArray(task2(),shift)));
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
     * 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static int[] task1(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        return array;
    }

    /**
     * 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
     * значениями 1 2 3 4 5 6 7 8 ... 100;
     */
    public static int[] task2() {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
     * умножить на 2;
     */
    public static int[] task3() {
        int array[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов
     * одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     * (можно только одну из диагоналей, если обе сложно). Определить элементы одной из
     * диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
     * [1][1], [2][2], ..., [n][n];
     */
    public static void task4(final int numb) {
        int[][] array = new int[numb][numb];

        for (int i = 0, j = array.length - 1; i < array.length && j >= 0; i++, j--) {
            array[i][i] = 1;
            array[i][j] = 1;
        }
        for (int[] i : array) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    /**
     * 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
     * одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
     */
    public static int[] task5(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    /**
     * 6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
     */
    public static void task6(int[] array) {
        int max = array[0];
        int min = max;

        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        System.out.println("Минимальный элемент: " + min);
        System.out.println("Максимальный элемент: " + max);
    }

    /**
     * 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
     * массива равны.
     * Примеры:
     * checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
     * checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
     * граница показана символами |||, эти символы в массив не входят и не имеют никакого
     * отношения к ИЛИ.
     */
    public static boolean checkBalance(final int[] array) {
        if (array.length > 1) {
            boolean flag = false;
            int check_length = array.length;
            while (check_length > 0) {
                //            сумма левой части
                int sum_left = 0;
                //            сумма правой части
                int sum_right = 0;
                //            цикл считает сумму левой части от нуля до "проверяемая длинна массива - 2", что бы оставить одно число спарва.
                for (int i = 0; i < check_length - 1; i++) {
                    sum_left += array[i];
                }
                //            цикл считает сумму правой части от "проверяемая длинна левой части - 1" до "длинна массива - 1"
                for (int j = check_length - 1; j <= array.length - 1; j++) {
                    sum_right += array[j];
                }
                if (sum_left == sum_right) {
                    flag = true;
                    break;
                } else {
                    check_length--;
                }
            }
            return flag;
        } else {
            return false;
        }
    }

    /**
     * 8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть
     * положительным, или отрицательным), при этом метод должен сместить все элементы массива
     * на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
     * вспомогательными массивами.
     * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
     * При каком n в какую сторону сдвиг можете выбирать сами.
     */

    public static int[] shiftArray(final int[] array, int shift) {
        if (shift > 0) {
            for (int j = 0; j < shift; j++) {
                for (int i = 0; i < array.length - 1; i++) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        } else {
            for (int j = 0; j > shift; j--) {
                for (int i = array.length - 1; i > 0; i--) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
        }
        return array;
    }
}