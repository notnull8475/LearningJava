package ru.geekbrains.lesson_6.home_work;

public class Cat extends Animal {
    private static int numb;
    private static final int runDist = 200;

    public Cat(String name) {
        super(name);
        numb++;
    }

    @Override
    public void swim(int distance) {
        System.out.printf("Кот %s не умеет плавать\n", name);
    }

    @Override
    public void run(int distance) {
        if (distance <= runDist) {
            System.out.printf("Кот %s пробежал %dм\n", name, distance);
        } else {
            System.out.printf("Кот %s не может пробежать больше %dм\n", name, runDist);
        }
    }

    public static void getNumb() {
        System.out.printf("Создано %d котов\n", numb);
    }
}
