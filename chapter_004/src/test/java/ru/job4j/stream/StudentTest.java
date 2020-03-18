package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void levelOf() {
        Student s1 = new Student("s1", 20);
        Student s2 = new Student("s2", 24);
        Student s3 = new Student("s3", 36);
        List<Student> input = Arrays.asList(s1, null, s2, null, s3);
        List<Student> expected = List.of(s2, s3);
        assertThat(s1.levelOf(input, 20), is(expected));
    }
}
