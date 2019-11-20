package ru.job4j.tracker;

public class Animal {

    public Animal() {
        super();
        System.out.println("load animal");
    }

    public static void main(String[] args) {
        Animal tiger = new Tiger();
    }

}
