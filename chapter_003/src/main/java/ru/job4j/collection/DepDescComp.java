package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String leftStr, String rightStr) {
        int result = 0;
        int minSize = Math.min(leftStr.length(), rightStr.length());
        int firstDigit = 1;
        for (int i = firstDigit; i < minSize; i++) {
            if (leftStr.charAt(firstDigit) > rightStr.charAt(firstDigit)) {
                result = -Character.compare(leftStr.charAt(firstDigit), rightStr.charAt(firstDigit));
                break;
            }
            result = Character.compare(leftStr.charAt(i), rightStr.charAt(i));
        }
        result = (result == 0) ? Integer.compare(leftStr.length(), rightStr.length()) : result;
        return result;
    }
}
