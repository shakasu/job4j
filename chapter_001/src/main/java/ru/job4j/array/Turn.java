package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        // toThisIndex - середина массива
        double toThisIndex = (int) ((array.length / 2) - 1);
        int tmp;
        for (int index = 0; index <= toThisIndex; index++) {
            tmp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = tmp;
        }
        return array;
    }
}