package ru.job4j.condition;

public class Max {
    public static int max(int first, int second) {
        return (first > second) ? first : second;
    }

    public static int max(int a, int b, int c) {
        return max(a, max(b, c));
    }

    public static int max(int a, int b, int c, int d) {
        return max(a, max(b, c, d));
    }
}
