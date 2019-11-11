package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void factOne() {
        Factorial factorial = new Factorial();
        int in = 1;
        int expected = 1;
        int out = Factorial.calc(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void factZero() {
        Factorial factorial = new Factorial();
        int in = 0;
        int expected = 1;
        int out = Factorial.calc(in);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void factFive() {
        Factorial factorial = new Factorial();
        int in = 5;
        int expected = 120;
        int out = Factorial.calc(in);
        Assert.assertEquals(expected, out);
    }
}
