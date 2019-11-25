package ru.job4j.stragery;

import org.junit.Test;
import ru.job4j.ru.job4j.io.ru.stragery.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                                .append("  +  ")
                                .append(" +++ ")
                                .append("+++++")
                                .toString()
                )
        );
    }
}
