package ru.job4j.collection.staf;

import java.util.Comparator;

public class UserInByName implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
