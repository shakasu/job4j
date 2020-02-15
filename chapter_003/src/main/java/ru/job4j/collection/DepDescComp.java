package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String leftStr, String rightStr) {
        int result = 0;
        int minSize = Math.min(leftStr.length(), rightStr.length());
        boolean charIsDigit = false;
        int firstDigit = -1;
        for (int i = 0; i < minSize; i++) {
            if (!charIsDigit) {
                charIsDigit = Character.isDigit(leftStr.charAt(i));
                firstDigit = i;
            }
            boolean charNotEqual = leftStr.charAt(i) != rightStr.charAt(i);
            int charCompare = Character.compare(leftStr.charAt(i), rightStr.charAt(i));
            if (charNotEqual && i == firstDigit) {
                result = -charCompare;
                break;
            }
            if (charNotEqual) {
                result = charCompare;
                break;
            }
            if (result == 0) {
                result = Integer.compare(leftStr.length(), rightStr.length());
            }
        }
        return result;
    }
}
