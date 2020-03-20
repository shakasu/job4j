package ru.job4j.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
        return students
                .stream()
                .flatMap(stud -> stud
                        .getUnits()
                        .stream()
                        .map(str -> new Holder(str, stud.getName()))
                )
                .collect(
                        Collectors.groupingBy(t -> t.key,
                                Collector.of(
                                        HashSet::new,
                                        (set, el) -> set.add(el.value),
                                                (left, right) ->  {
                                            left.addAll(right);
                                            return left;
                                        }
                                )
                        )
                );
    }
}
