package ru.job4j.collection.staf;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static java.lang.CharSequence.compare;

public class User implements Comparable<User> {
    private String name;
    private int priority;

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public User(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(@NotNull User o) {
        int result;
        if (compare(name, o.name) == 0) {
            result = Integer.compare(priority, o.priority);
        } else {
            result = compare(name, o.name);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return priority == user.priority && Objects.equals(name, user.name);
    }
}
