package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println("The " + this.name + " eats a " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        Cat black = new Cat();
        gav.giveNick("Gav");
        black.giveNick("Noname cat");
        gav.eat("kotleta");
        black.eat("fish");
        gav.show();
        black.show();
    }
}