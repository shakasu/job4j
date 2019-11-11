package ru.job4j.array;

public class SortSelected {

    public static int[] sort(int[] data) {
        int tmp, min, index;
        for (int i = 0; i < data.length; i++) {
        min = MinDiapason.findMin(data, i, data.length);
        index = FindLoop.indexOfRange(data, min, i, data.length);
        tmp = data[index];
        data[index] = data[i];
        data[i] = tmp;
        }
        return data;
    }
}