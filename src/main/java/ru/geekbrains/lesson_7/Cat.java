package ru.geekbrains.lesson_7;


/**
 * Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
 * Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
 * Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
 * Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
 * Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */


public class Cat {
    private String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        satiety = plate.decreaseFood(appetite);
        System.out.println(satiety ? "Cat ate" : "Cat not ate");
    }

    public void info() {
        System.out.println("Cat name: " + name + "\n" + "Cat appetite: " + appetite + "\n" + "Cat is hungry? " + (satiety ? "no\n" : "yes\n"));
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }
}
