package ru.job4j.array;

public class TurnForChar {
    public char[] back(char[] array) {
        // toThisIndex - середина массива
        double toThisIndex = (int) ((array.length/2)-1);
        char tmp;
        for (int index = 0; index<=toThisIndex; index++) {
            tmp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = tmp;
        }
        return array;
    }
}
