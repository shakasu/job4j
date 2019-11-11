package ru.job4j.condition;

public class TrgArea {
    public static double area(double a, double b, double c) {
        double areaT, halfP;
        halfP = (a + b + c) / 2;
        areaT = Math.sqrt(halfP * (halfP - a) * (halfP - b) * (halfP - c));
        return areaT;
    }

    public static void main(String[] args) {
        double rsl = TrgArea.area(2, 2, 2);
        System.out.println("area (2, 2, 2) = " + rsl);

        double rsl1 = TrgArea.area(3, 4, 5);
        System.out.println("area (3, 4, 5) = " + rsl1);
    }
}
