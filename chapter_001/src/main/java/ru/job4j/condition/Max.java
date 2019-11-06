package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        int result = (left>=right) ? left : right; //нестрогое сравнение позволит
        // избежать ошибки при равенстве параметров данного метода
        return result;
    }
}
