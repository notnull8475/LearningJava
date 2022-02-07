package ru.geekbrains.lesson_6.home_work;

public class Dog extends Animal {
    private static int numb;
    private static final int runDist = 500;
    private static final int swimDist = 10;


    public Dog(String name) {
        super(name);
        numb++;
    }

    @Override
    public void swim(int distance) {
        if (distance < swimDist) {
            System.out.printf("Собака %s проплыла %dм\n", name, distance);
        } else {
            System.out.printf("Собака %s не может проплыть больше %dм\n", name, swimDist);
        }
    }

    @Override
    public void run(int distance) {
        if (distance <= runDist) {
            System.out.printf("Собака %s пробежала %dм\n", name, distance);
        } else {
            System.out.printf("Собака %s не может пробежать больше %dм\n", name, runDist);
        }
    }


    public static void getNumb() {
        System.out.printf("Создано %d собак\n", numb);
    }
}
