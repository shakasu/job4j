package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CounterTest {

    @Test
    public void add(){
        Counter counter = new Counter();
        int start = 1;
        int finish = 10;
        int expected = 30;
        int out = Counter.add(start, finish);
        Assert.assertEquals(expected,out);
    }

    @Test
    public void add1(){
        Counter counter = new Counter();
        int start = 2;
        int finish = 100;
        int expected = 2550;
        int out = Counter.add(start, finish);
        Assert.assertEquals(expected,out);
    }
}
