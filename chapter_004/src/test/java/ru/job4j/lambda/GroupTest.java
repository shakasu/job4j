package ru.job4j.lambda;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GroupTest {
       @Test
    public void sections() {
        Map<String, Set<String>> expected = Count.output();
        List<Student> input = Count.input();
        Map<String, Set<String>> result = Group.sections(input);
        assertThat(result, is(expected));
    }
}
