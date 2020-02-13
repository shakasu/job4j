package ru.job4j.collection;

import java.util.Comparator;

/**
 * Метод compare сравнивает левую и правую строчку.
 * по заданию: первые элементы по убываюнию, последующие по возрастанию.
 * вводим результат сравнение элементов compareInt.
 * первый оператор условия (строчка 27) сравнит первые элементы двух строк по убыванию,
 * поэтому вернем со знаком "минус" (строчка 30).
 * второй оператор условия (строчка 33) сравнит элементы между вторым и последним из более короткой строчки,
 * по возрастанию, поэтому знак "плюс" (строчка 34).
 * третий оператор (строчка 38) вне цикла нужен для второго крайнего случая, когда длины у строк разные,
 * и строки идентичны вплоть до последнего элемента более длинной.
 * соответственно более длинная строка будет "больше".
 */

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String leftStr, String rightStr) {
        int result = 0;
        String[] leftStrSplit = leftStr.split("/");
        String[] rightStrSplit = rightStr.split("/");
        int shorterSize = Math.min(leftStrSplit.length, rightStrSplit.length);
        Integer leftStrSplitLength = leftStrSplit.length;
        Integer rightStrSplitLength = rightStrSplit.length;
        for (int index = 0; index < shorterSize; index++) {
            char[] leftChar = leftStrSplit[index].toCharArray();
            char[] rightChar = rightStrSplit[index].toCharArray();
            int lastCharIndex = leftChar.length - 1;
            int compareInt = Character.compare(leftChar[lastCharIndex], rightChar[lastCharIndex]);
            if (index == 0 && compareInt != 0) {
                result = -compareInt;
                break;
            }
            if (index != 0 && compareInt != 0) {
                result = compareInt;
                break;
            }
        }
        if (result == 0) {
            result = leftStrSplitLength.compareTo(rightStrSplitLength);
        }
        return result;
    }
}
