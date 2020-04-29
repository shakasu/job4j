package ru.job4j.conversion;

import java.util.Comparator;

public class AddressComp implements Comparator<ru.job4j.conversion.Address> {
    @Override
    public int compare(ru.job4j.conversion.Address o1, ru.job4j.conversion.Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
