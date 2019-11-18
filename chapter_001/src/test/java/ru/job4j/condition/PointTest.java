package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(-12, -35);
        Point b = new Point(72, 210);
        double out = a.distance(b);
        double expected = 259;
        Assert.assertEquals(expected, out, 0.01);

    }
}
