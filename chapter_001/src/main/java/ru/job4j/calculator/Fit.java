package ru.job4j.calculator;

public class Fit {
    public static double manWeight(double height) {
        double perfectManFit1 = 1.15*(height-100);
        return perfectManFit1;
    }
    public static double womanWeight(double height) {
        double perfectWomanFit = 1.15*(height-110);
        return perfectWomanFit;
    }

    public static void main(String[] args) {
        double man = manWeight(170);
        System.out.println("Man 170 is " + man);

        double woman = womanWeight(185);
        System.out.println("Woman 185 is " + woman);
    }
}
