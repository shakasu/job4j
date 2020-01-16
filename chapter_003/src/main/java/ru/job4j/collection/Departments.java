package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Departments {

    public static List<String > fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (int i = 0; i < value.split("/").length; i++) {
                if (tmp.isEmpty()) {
                    tmp.add(value.split("/")[i]);
                } else {
                    tmp.add(value.split("/")[i - 1] + start + "/" + value.split("/")[i]);
                }
            }
            /*for (String el : value.split("/")) {
                if (tmp.isEmpty()) {
                    tmp.add(el);
                } else {
                    tmp.add(el + start + "/" + el);
                }
                // tmp.add start + "/" + el
            }*/
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {}

    public static void sortDesc(List<String> orgs) {}
}
