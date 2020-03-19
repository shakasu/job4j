package ru.job4j.search;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Karen", "1", "123456", "SPb")
        );
        var persons = phones.find("Karen");
        assertThat(persons.iterator().next().getSurname(), is("1"));
    }
}
