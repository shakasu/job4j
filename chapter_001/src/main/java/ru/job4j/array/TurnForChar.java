package ru.job4j.array;

public class TurnForChar {
    public char[] back(char[] array) {
        char tmp;
        for (int index = 0; index < (array.length / 2); index++) {
            tmp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = tmp;
        }
        return array;
    }
}
