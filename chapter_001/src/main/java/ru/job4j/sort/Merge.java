package ru.job4j.sort;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        if (rsl.length == 0) {
            return right;
        }
        if (right.length == 0) {
            return left;
        }
        if (left.length == 0) {
            return right;
        }

        int ind = 0;
        int leInd = 0;
        int riInd = 0;

        while ((leInd < left.length) && (riInd < right.length)) {
             if (right[riInd] < left[leInd]) {
                    rsl[ind] = right[riInd];
                    riInd++;
                } else {
                    rsl[ind] = left[leInd];
                    leInd++;
             }
        ind++;
        }

        for (int tmpInd = 0; tmpInd < rsl.length; tmpInd++) {
            int[] tmp = new int[rsl.length];
            if (riInd == right.length) {
                tmp = left;
                if (tmpInd == 0) {
                    tmpInd = leInd;
                }
            }
            if (leInd == left.length) {
                tmp = right;
                if (tmpInd == 0) {
                    tmpInd = riInd;
                }
            }
            rsl[ind] = tmp[tmpInd];
            ind++;
            if (ind == rsl.length) {
                break;
            }
        }

        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}