package ru.job4j.array;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int out = 0; out!=size; out++) {
            for (int inner = 0; inner!=size; inner++) {
                table[out][inner] = (1+inner)*(1+out);
            }
        }
        return table;
    }
}