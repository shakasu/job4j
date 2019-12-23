package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int changeInt = money - price;
        for (int i = 0; i < coins.length; i++) {
            while (changeInt > coins[i]) {
                rsl[size++] = coins[i];
                changeInt = changeInt - coins[i];
            }
            if (changeInt == coins[i]) {
                rsl[size++] = coins[i];
                break;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}