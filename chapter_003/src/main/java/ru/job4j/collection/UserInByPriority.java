package ru.job4j.collection;

import java.util.Comparator;

public class UserInByPriority implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return  Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
