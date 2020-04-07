package ru.job4j.pojo;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        License second = new License();
        first.setCode("audio");
        second.setCode("audio");
        assertThat(first, is(second));
    }
}
