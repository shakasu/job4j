package ru.job4j.converter;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {

    @Test
    public void convertTest() {
        Integer[][] input = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        Converter converter = new Converter();
        List<Integer> actual = converter.convert(input);
        assertThat(actual, is(expected));
    }

    @Test
    public void convertTestList() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> expected = List.of(1, 2, 3, 4);
        Converter converter = new Converter();
        List<Integer> actual = converter.convert(matrix);
        assertThat(actual, is(expected));
    }
}
