package ru.job4j.collection;
import java.util.Comparator;
public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String lStr, String rStr) {
        int rsl = rStr.split("/")[0].compareTo(lStr.split("/")[0]);
        return rsl != 0 ? rsl : lStr.compareTo(rStr);
    }
}