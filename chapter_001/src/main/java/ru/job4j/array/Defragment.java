package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        int i = 0;
        for (int index = 0; index < array.length; index++) {
            String cell = array[index];
            if (cell == null) {
                while (array[i] == null) {
                    i++;
                }
                array[index] = array[i];
                array[i] = null;
            }
            System.out.print(array[index] + " ");
            if (array[0] != null) {
                i++;
            }
            if (i == array.length) {
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }
}