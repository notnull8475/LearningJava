package ru.geekbrains.lesson_4;

import java.util.Arrays;
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

// TODO Доработать алгоритм проверки
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


//    TODO доработать логику ИИ в крестиках ноликах

    public static int[] aiTurn1() {
        int[] result = new int[2];

        int[][][] aiMap = new int[SIZE][SIZE][3];
        /*копия игровой карты
         * в которой будут указаны
         * вес - то есть ценность ячейки для хода AI
         * int[SIZE][SIZE][0] - значение занимаемое на карте
         * int[SIZE][SIZE][1] - ценность для атаки ИИ
         * int[SIZE][SIZE][2] - ценность для защиты ИИ
         * */

//        проходим по каждой ячейке массива (карты)
//        копируем в свой массив
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == DOT_O) {
                    aiMap[y][x][0] = 0;
                }
                if (map[y][x] == DOT_X) {
                    aiMap[y][x][0] = 1;
                }
                if (map[y][x] == DOT_EMPTY) {
                    aiMap[y][x][0] = 2;
                }

                for (int i = 0; i < SIZE; i++) {
                    if (map[y][i] == DOT_O) {
                        aiMap[y][x][2]++;
                    }
                    if (map[y][i] == DOT_X) {
                        aiMap[y][x][1]++;
                    }

                    if (map[i][x] == DOT_O) {
                        aiMap[y][x][2]++;
                    }
                    if (map[i][x] == DOT_X) {
                        aiMap[y][x][1]++;
                    }


                    int k = i + 1;

                    if (x - k > -1 && y - k > -1 && map[y - k][x - k] == DOT_O) {
                        aiMap[y][x][2]++;
                    }
                    if (x - k > -1 && y - k > -1 && map[y - k][x - k] == DOT_X) {
                        aiMap[y][x][1]++;
                    }
                    if (x + k < SIZE && y + k < SIZE && map[y + k][x + k] == DOT_O) {
                        aiMap[y][x][2]++;
                    }
                    if (x + k < SIZE && y + k < SIZE && map[y + k][x + k] == DOT_X) {
                        aiMap[y][x][1]++;
                    }


                    if (x + k < SIZE && y - k > -1 && map[y - k][x + k] == DOT_O) {
                        aiMap[y][x][2]++;
                    }
                    if (x + k < SIZE && y - k > -1 && map[y - k][x + k] == DOT_X) {
                        aiMap[y][x][1]++;
                    }
                    if (x - k > -1 && y + k < SIZE && map[y + k][x - k] == DOT_O) {
                        aiMap[y][x][2]++;
                    }
                    if (x - k > -1 && y + k < SIZE && map[y + k][x - k] == DOT_X) {
                        aiMap[y][x][1]++;
                    }

                }
            }
        }

        int[] p = {0, 0};
        int[] a = {0, 0};
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (aiMap[a[0]][a[1]][1] < aiMap[i][j][1] && isCellValid(j, i)) {
                    System.out.println(Arrays.toString(a));
                    a[0] = i;
                    a[1] = j;
                }
                if (aiMap[p[0]][p[1]][2] < aiMap[i][j][2] && isCellValid(j, i)) {
                    System.out.println(Arrays.toString(p));
                    p[0] = i;
                    p[1] = j;
                }
            }
        }
        if (aiMap[a[0]][a[1]][1] > aiMap[p[0]][p[1]][2]) {
            if (isCellValid(a[0], a[1])) {
                map[a[0]][a[1]] = DOT_O;
                return a;
            }
        } else {
            if (isCellValid(p[0], p[1])) {
                map[p[0]][p[1]] = DOT_O;
                return p;
            }
        }
        return aiTurn();
    }
}
