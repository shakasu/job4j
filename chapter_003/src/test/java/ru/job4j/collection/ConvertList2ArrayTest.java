package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.collection.staf.ConvertList2Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class ConvertList2ArrayTest {

    @Test
    public void when12And3456Then123456() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{1, 2});
        input.add(new int[]{3, 4, 5, 6});
        List<Integer> result = list.convert(input);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4, 5, 6
        );
        assertThat(result, is(expect));
    }

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
}
