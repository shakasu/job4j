package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        int in1 = -12;
        int in2 = -35;
        int in3 = 72;
        int in4 = 210;
        double expected = 259;
        double out = Point.distance(in1, in2, in3, in4);
        Assert.assertEquals(expected, out, 0.01);

    }
}
