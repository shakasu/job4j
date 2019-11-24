package ru.job4j.ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int items = 11;
        boolean step = true;
        System.out.println("Игра 11 спичек на столе.");
        System.out.println("Игроки по очереди берут со стола от одной до трех спичек.");
        System.out.println("Победитель - забравший последние спички о стола");
        System.out.println("Первый игрок введи имя.");
        String name1 = input.nextLine();
        System.out.println("Второй игрок введи имя.");
        String name2 = input.nextLine();
        while (items != 0) {
            String name = step ? name1 : name2;
            System.out.println(name + ", бери спички");
            int select = Integer.valueOf(input.nextLine());
            items = items - select;
            System.out.println("На столе " + items + " спичек.");
            step = !step;
        }
        String name = !step ? name1 : name2;
        System.out.println("Поздравляю, " + name + ", ты забрал последие спички!");
    }
}
