package ru.geekbrains.lesson_4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    /*
     * 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
     * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
     * 3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
     * 4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
     */
    public static int SIZE = 6;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
//        создаем карту - двумерный массив со значениями "•" (DOT_EMPTY)
        initMap();
//        Выводим массив-карту в консоль
        printMap();
//        Бесконечный цикл
        while (true) {
            int[] res;
//            запрос хода человека
            res = humanTurn();
//            Выводим массив-карту в консоль
            printMap();
//            проверяем победу.
            if (checkWin(res[1], res[0])) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            res = aiTurn();
            printMap();
            if (checkWin(res[1], res[0])) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }

        System.out.println("Игра закончена");
    }

    public static boolean checkWin(int x, int y) {
        int xs = 0; // по горизонтали
        int ys = 0; // по вертикали
        int xd = 1; // по диагонали наклон влево
        int yd = 1; // по диагонали наклон вправо

        for (int j = 0; j < SIZE; j++) {
//            1. реализация проверки по оси X
            if (map[j][y] == map[x][y]) {
                xs++;
            }
//            2. проверка по Y
            if (map[x][j] == map[x][y]) {
                ys++;
            }
//            3. проверка по диагонали = наклон влево \

            int i = j + 1;
            if (x - i > -1 && y - i > -1) {
                if (map[x - i][y - i] == map[x][y]) {
                    xd++;
                }
            }
            if (x + i < SIZE && y + i < SIZE) {
                if (map[x + i][y + i] == map[x][y]) {
                    xd++;
                }
            }

//            4. проверка по диагонали = наклон вправо /
            if (x + i < SIZE && y - i > -1) {
                if (map[x + i][y - i] == map[x][y]) {
                    yd++;
                }
            }
            if (y + i < SIZE && x - i > -1) {
                if (map[x - i][y + i] == map[x][y]) {
                    yd++;
                }
            }
        }
        return xs == DOTS_TO_WIN || ys == DOTS_TO_WIN || xd == DOTS_TO_WIN || yd == DOTS_TO_WIN;
    }

    //проверка заполнения карты не символами DOT_EMPTY
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    //    Ход компьютера - рандомное значение для каждой "оси" в пределах размерности двумерного массива
    //    проверка на занятость поля
    public static int[] aiTurn() {
        int[] res = new int[2];
        do {
            res[0] = rand.nextInt(SIZE);
            res[1] = rand.nextInt(SIZE);
        } while (!isCellValid(res[0], res[1]));
        System.out.println("Компьютер походил в точку " + (res[0] + 1) + " " + (res[1] + 1));
        map[res[1]][res[0]] = DOT_O;
        return res;
    }

    //    ожидание хода человека и проверка на занятость поля введеный координат
    public static int[] humanTurn() {
        int[] res = new int[2];
        do {
            System.out.println("Введите координаты в формате X Y");
            res[0] = sc.nextInt() - 1; // x
            res[1] = sc.nextInt() - 1; // y
        } while (!isCellValid(res[0], res[1])); // while(isCellValid(x, y) == false)
        map[res[1]][res[0]] = DOT_X;
        return res;
    }

    //    проверка на занятость ячейки
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    //    Инициализация карты - заполнение символами DOT_EMPTY
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    //    Вывод массива в консоль с заголовками по вертикали и горизонтали.
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
