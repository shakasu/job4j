package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String rsl = "Неизвестное слово. " + eng;
        return rsl;
    }

    public static void main(String[] args) {
        DummyDic dictionary = new DummyDic();
        System.out.println(dictionary.engToRus("basic"));
    }
}
