package ru.job4j.counter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RangeCountTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        RangeCount function = new RangeCount();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        RangeCount function = new RangeCount();
        List<Double> result = function.diapason(5, 8, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        RangeCount function = new RangeCount();
        List<Double> result = function.diapason(100, 101, x -> 2 * Math.log10(x) + 1);
        List<Double> expected = Arrays.asList(5D);
        assertThat(result, is(expected));
    }
}
