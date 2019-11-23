package ru.job4j.ru.job4j.io.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Beep-beep, I'm going by transport");
    }

    @Override
    public void passengers(int passenger) {
        System.out.println("The transport carries " + passenger + " passengers");
    }

    @Override
    public int refuel(int fuel) {
        int price = fuel * 120;
        return price;
    }
}
