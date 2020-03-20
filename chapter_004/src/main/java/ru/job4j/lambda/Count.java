package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Count {
    public static List<Student> input() {
        return List.of(
                new Student("Artem", Set.of("painting", "dancing", "chess")),
                new Student("Sasha", Set.of("chess", "music")),
                new Student("Masha", Set.of("swimming")),
                new Student("Ura", Set.of("painting", "chess")),
                new Student("Petr", Set.of("math", "dancing", "music")),
                new Student("Andrew", Set.of("dancing"))
        );
    }

    public static Map<String, Set<String>> output() {
        return Map.of(
                "painting", Set.of("Artem", "Ura"),
                "dancing", Set.of("Artem", "Petr", "Andrew"),
                "chess", Set.of("Artem", "Ura", "Sasha"),
                "music", Set.of("Sasha", "Petr"),
                "swimming", Set.of("Masha"),
                "math", Set.of("Petr")
        );
    }
}
