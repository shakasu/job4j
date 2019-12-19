package ru.job4j.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static java.lang.CharSequence.compare;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull User o) {
        int result = 0;
        if (compare(name, o.name) == 0) {
            result = Integer.compare(age, o.age);
        } else {
            result = compare(name, o.name);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }
}
