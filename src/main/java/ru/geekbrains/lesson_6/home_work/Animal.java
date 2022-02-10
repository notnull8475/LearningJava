package ru.geekbrains.lesson_6.home_work;

public abstract class Animal {
    public final String name;
    private static int numb;

    public Animal(String name) {
        this.name = name;
        numb++;
    }

    public abstract void swim(int distance);

    public abstract void run(int distance);

    public static void getNumb(){
        System.out.printf("Создано %d животных\n",numb);
    }
}
