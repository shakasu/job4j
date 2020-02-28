package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String leftStr, String rightStr) {
        int result = 0;
        int minSize = Math.min(leftStr.length(), rightStr.length());
        for (int i = 1; i < minSize; i++) {
            if (leftStr.charAt(1) > rightStr.charAt(1)) {
                result = -Character.compare(leftStr.charAt(i), rightStr.charAt(i));
                break;
            }
            result = Character.compare(leftStr.charAt(i), rightStr.charAt(i));
        }
        result = (result == 0) ? Integer.compare(leftStr.length(), rightStr.length()) : result;
        return result;
    }
}
