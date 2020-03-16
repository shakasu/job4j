package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void test() {
        List<String> input = Arrays.asList("k2/sk1", "k1/sk1", "k1/sk2");
        List<String> expect = Arrays.asList("k2/sk1", "k1/sk2", "k1/sk1");
        Departments.sortDesc(input);
        List<String> result = input;
        assertThat(result, is(expect));
    }

    @Test
    public void test2() {
        List<String> input = Arrays.asList("k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk1/ssk3");
        List<String> expect = Arrays.asList("k1/sk1/ssk3", "k1/sk1/ssk2", "k1/sk1/ssk1");
        Departments.sortDesc(input);
        List<String> result = input;
        assertThat(result, is(expect));
    }
}