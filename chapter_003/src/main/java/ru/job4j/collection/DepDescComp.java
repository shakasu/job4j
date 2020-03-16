package ru.job4j.collection;
import java.util.Comparator;
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String lStr, String rStr) {
        int rsl = 0;
        int minSize = Math.min(lStr.length(),rStr.length());
        int compFirstDep = Character.compare(lStr.charAt(1), rStr.charAt(1));
        for (int index = 0; index < minSize; index++) {
            if (compFirstDep != 0) { //если первые департаменты не равны,
                // то сразу сортируем их в обратном порядке
                rsl = -compFirstDep;
                break;
            }
            if (lStr.charAt(index) != rStr.charAt(index)) { //если первые департаменты равны, то сортируем в прямом порядке
                rsl = Character.compare(lStr.charAt(index), rStr.charAt(index));
                break;
            }
        }
        if (rsl == 0 && lStr.length() != rStr.length() && lStr.charAt(1) == rStr.charAt(1)) { // если длиннейший департамент
            // начинается абсолютно также как и меньший, то сначала будет меньший
            rsl = Integer.compare(lStr.length(), rStr.length());
        }
        return rsl;
    }
}