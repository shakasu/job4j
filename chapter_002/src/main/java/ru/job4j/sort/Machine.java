package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int changeInt = money - price;
        for (int i = 0; i < 4; i++) {
            while (changeInt > COINS[i]) {
                rsl[size++] = COINS[i];
                changeInt = changeInt - COINS[i];
            }
            if (changeInt == COINS[i]) {
                rsl[size++] = COINS[i];
                break;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}