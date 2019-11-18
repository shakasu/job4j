package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenNotExist() {
        Triangle triangle = new Triangle();
        double out = triangle.area(0, 0, 3, 0, 4, 0);
        double expected = -1;
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenExist() {
        Triangle triangle = new Triangle();
        double out = triangle.area(0, 0, 0, 3, 4, 0);
        double expected = 6;
        Assert.assertEquals(expected, out, 0.01);
    }
}