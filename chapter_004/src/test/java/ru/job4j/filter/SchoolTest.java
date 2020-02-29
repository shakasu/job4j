package ru.job4j.filter;

import org.junit.Test;

import java.util.List;

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
}
