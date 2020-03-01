package ru.job4j.сonversion;

import java.util.Comparator;

public class AddressComp implements Comparator<Address> {
    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}
