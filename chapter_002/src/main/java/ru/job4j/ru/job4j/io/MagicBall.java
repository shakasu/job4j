package ru.job4j.ru.job4j.io;

import java.util.Scanner;
import java.util.Random;


public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("I`m great Oracle, what do you want to know");
        input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                System.out.println("Yes!");
                break;
            case -1:
                System.out.println("No!");
                break;
            default:
                System.out.println("May be?");
        }
    }
}
