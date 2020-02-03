package ru.job4j.collection;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortAsc() {
        List<String> input = Arrays.asList("k2", "k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k2");
        Departments.sortAsc(input);
        List<String> result = input;
        assertThat(result, is(expect));
    }

    @Test
    public void sortDesc() {
        List<String> input = Arrays.asList("K2/SK1/SSK2", "K2/SK1");
        List<String> expect = Arrays.asList("K2/SK1", "K2/SK1/SSK2");
        Departments.sortDesc(input);
        List<String> result = input;
        assertThat(result, is(expect));
    }

    @Test
    public void sortDescSameSize() {
        List<String> input = Arrays.asList("k2/sk1", "k1/sk2", "k1/sk1");
        List<String> expect = Arrays.asList("k2/sk1", "k1/sk1", "k1/sk2");
        Departments.sortDesc(input);
        List<String> result = input;
        assertThat(result, is(expect));
    }
}