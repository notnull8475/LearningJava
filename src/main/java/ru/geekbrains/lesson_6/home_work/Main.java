package ru.geekbrains.lesson_6.home_work;

public class Main {
    public static void main(String[] args) {

        String[] catNames = {
                "Барсик",
                "Марси",
                "Тишка"
        };
        String[] dogNames = {
                "Бобик",
                "Челси",
                "Лотти",
                "Рузвельт"
        };

        Cat[] cats = new Cat[catNames.length];
        Dog[] dogs = new Dog[dogNames.length];

        for (int i = 0; i < dogNames.length; i++) {
            dogs[i] = new Dog(dogNames[i]);
            dogs[i].run(200);
            dogs[i].swim(100);
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < catNames.length; i++) {
            cats[i] = new Cat(catNames[i]);
            cats[i].run(200);
            cats[i].swim(100);
            System.out.println();
        }

        System.out.println();
        Animal.getNumb();
        Cat.getNumb();
        Dog.getNumb();
    }


}
