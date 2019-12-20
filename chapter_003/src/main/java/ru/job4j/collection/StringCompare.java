package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rls = 0;
        int size = (left.length() < right.length()) ? left.length() : right.length();
        for (int i = 0; i < size; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                rls = Character.compare(left.charAt(i), right.charAt(i));
                break;
            } else {
                if (i == size - 1) {
                    rls = Integer.compare(left.length(), right.length());
                }
            }
        }
        return rls;
    }
}
