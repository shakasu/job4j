package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FitnessTest {
    @Test
    public void whenNikGreaterIvanOne() {
        Fitness counter = new Fitness();
        int nik = 100;
        int ivan = 90;
        int expected = 1;
        int out = Fitness.calc(ivan, nik);
        Assert.assertEquals(expected, out);
    }
    @Test
    public void whenNikGreaterIvanTwo() {
        Fitness counter = new Fitness();
        int nik = 70;
        int ivan = 40;
        int expected = 2;
        int out = Fitness.calc(ivan, nik);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenNikGreaterIvanTwoSecond() {
        Fitness counter = new Fitness();
        int nik = 90;
        int ivan = 50;
        int expected = 2;
        int out = Fitness.calc(ivan, nik);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenIvanGreaterNik() {
        Fitness counter = new Fitness();
        int nik = 90;
        int ivan = 95;
        int expected = 0;
        int out = Fitness.calc(ivan, nik);
        Assert.assertEquals(expected, out);
    }
}
