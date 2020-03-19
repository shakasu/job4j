package ru.job4j.stream;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.scope, o.scope);
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .takeWhile(v -> v.scope > bound)
                .collect(Collectors.toList());
    }
}
