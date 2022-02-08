package ru.geekbrains.lesson_7;
/*
* Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
*/
public class Plate {
    private int food;
    //    максимальная вместимость тарелки
    private int plateSize = 100;

    public Plate(int food) {
        fillPlate(food);
    }

    public boolean decreaseFood(int appetite) {
        if (appetite > food) {
            return false;
        } else {
            food -= appetite;
            return true;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void fillPlate(int foodVolume) {
        if (foodVolume > plateSize) {
            food = plateSize;
            System.out.printf("Max size of plate is %d\n", plateSize);
        } else {
            food += foodVolume;

        }
        System.out.printf("Plate filled, plate fullness is: %d percent\n", ((food/plateSize)*100));
    }

    public int getPlateSize() {
        return plateSize;
    }

    public void setPlateSize(int plateSize) {
        this.plateSize = Math.abs(plateSize);
    }
}
