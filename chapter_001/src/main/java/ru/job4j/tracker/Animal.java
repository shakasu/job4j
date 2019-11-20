package ru.job4j.tracker;

public class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
        super();
        System.out.println("load animal");
    }

    public static void main(String[] args) {
        Animal tiger = new Tiger();
    }

}
