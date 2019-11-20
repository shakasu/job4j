package ru.job4j.tracker;

public class Predator extends Animal {

    public Predator (String name) {
        super(name);
    }

    public Predator() {
        super();
        System.out.println("load predator");
    }
}
