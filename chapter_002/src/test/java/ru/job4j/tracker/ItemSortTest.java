package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemSortTest {

    @Test
    public void whenDecrease() {
        List<Item> expected = new ArrayList<>();
        List<Item> result = new ArrayList<>();
        Item test1 = new Item("test1", 1);
        Item test2 = new Item("test2", 2);
        Item test3 = new Item("test3", 3);
        expected.add(test1);
        expected.add(test2);
        expected.add(test3);
        result.add(test1);
        result.add(test3);
        result.add(test2);
        Collections.sort(result);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIncrease() {
        List<Item> expected = new ArrayList<>();
        List<Item> result = new ArrayList<>();
        Item test1 = new Item("test1", 3);
        Item test2 = new Item("test2", 2);
        Item test3 = new Item("test3", 1);
        expected.add(test1);
        expected.add(test2);
        expected.add(test3);
        result.add(test1);
        result.add(test3);
        result.add(test2);
        Collections.sort(result, Collections.reverseOrder());
        assertThat(result, is(expected));
    }
}
