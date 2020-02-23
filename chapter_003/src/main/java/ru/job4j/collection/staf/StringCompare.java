package ru.job4j.collection.staf;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rls = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                rls = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
            if (rls == 0) {
                rls = Integer.compare(left.length(), right.length());
            }
        }
        return rls;
    }
}
