package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox denonDP200USB = new Jukebox();
        denonDP200USB.music(42);
        denonDP200USB.music(1);
    }
}
