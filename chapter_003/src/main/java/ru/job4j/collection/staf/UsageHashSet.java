package ru.job4j.collection.staf;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("Lada");
        autos.add("BMV");
        autos.add("Volvo");
        autos.add("Toyouta");
        for (String auto: autos) {
            System.out.println(auto);
        }
    }
}
