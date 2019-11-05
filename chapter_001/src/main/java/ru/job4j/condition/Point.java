package ru.job4j.condition;

public class Point {
    public static double distance(int x1, int y1, int x2, int y2) {
        double resultDis;
        resultDis = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        return resultDis;
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);

        double result1 = distance(0, 0, 3, 4);
        System.out.println("result1 (0, 0) to (3, 4) " + result1);

        double result2 = distance(-12, -35, 72, 210);
        System.out.println("result2 (-12, -35) to (72, 210) " + result2);
    }
}
