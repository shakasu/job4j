package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void distance3dNotSame() {
        Point a = new Point(3, 4, 100);
        Point b = new Point(0, 0, 88);
        double out = a.distance3d(b);
        double expected = 13;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance3dSame() {
        Point a = new Point(-12, -35, 10);
        Point b = new Point(72, 210, 10);
        double out = a.distance3d(b);
        double expected = 259;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void distance() {
        Point a = new Point(-12, -35);
        Point b = new Point(72, 210);
        double out = a.distance(b);
        double expected = 259;
        Assert.assertEquals(expected, out, 0.01);
    }
}
