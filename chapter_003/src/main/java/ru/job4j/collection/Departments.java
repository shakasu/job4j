package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Departments {

    public static List<String > fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            String rsl = null;
            for (String el : value.split("/")) {
                if (tmp.isEmpty()) {
                    rsl = el;
                } else {
                    rsl = rsl + "/" + el;
                }
                tmp.add(rsl);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {}

    public static void sortDesc(List<String> orgs) {}
}
