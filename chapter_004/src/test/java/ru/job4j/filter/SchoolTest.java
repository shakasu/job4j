package ru.job4j.filter;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    private final List<Student> students = List.of(
            new Student(1, "qwe"),
            new Student(51, "asd"),
            new Student(99, "zxc")
            );
    @Test
    public void whenC() {
        School school = new School();
        List<Student> actual = school.collect(students, student -> student.getScore() < 50);
        assertThat(actual.get(0).getName(), is("qwe"));
    }

    @Test
    public void whenB() {
        School school = new School();
        List<Student> actual = school.collect(students, student -> (student.getScore() >= 50 && student.getScore() < 70));
        assertThat(actual.get(0).getName(), is("asd"));
    }

    @Test
    public void whenA() {
        School school = new School();
        List<Student> actual = school.collect(students, student -> student.getScore() >= 70);
        assertThat(actual.get(0).getName(), is("zxc"));
    }

    @Test
    public void convertListToMapTest() {
        School school = new School();
        Student student1 = new Student(12, "petrov");
        Student student2 = new Student(52, "ivanov");
        Student student3 = new Student(77, "sidorov");
        List<Student> input = List.of(
                student1,
                student2,
                student3
        );
        Map<String, Student> expected = Map.of(
                "petrov", student1,
                "ivanov", student2,
                "sidorov", student3
        );
        Map<String, Student> actual = school.convertListToMap(input);
        assertThat(actual, is(expected));
    }
}
