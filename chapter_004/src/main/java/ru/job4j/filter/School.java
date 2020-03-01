package ru.job4j.filter;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> rls;
        rls = students.stream().filter(predict).collect(Collectors.toList());
        return rls;
    }

    public Map<String, Student> convertListToMap(List<Student> students){
        Map<String, Student> rls = null;
        rls = students.stream().distinct().collect(
                Collectors.toMap(
                        student -> student.getName(),
                        student -> student
                )
        );
        return rls;
    }
}
