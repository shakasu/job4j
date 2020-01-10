package ru.job4j.collection.staf;

import java.util.Comparator;

public class UserDeByPriority implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return  Integer.compare(o2.getPriority(), o1.getPriority());
    }
}
