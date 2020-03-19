package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.staf.*;

import java.util.*;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>(
                Set.of(
                        new User("Petr", 32),
                        new User("Ivan", 31)
                )
        );
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameIncrease() {
        List<User> expected = new ArrayList<>(
                List.of(
                        new User("Anton", 1),
                        new User("Boris", 2),
                        new User("Gleb", 3)
                )
        );
        List<User> result = new ArrayList<>(
                List.of(
                        new User("Boris", 2),
                        new User("Gleb", 3),
                        new User("Anton", 1)
                )
        );

        result.sort(new UserInByName());
        assertThat(result, is(expected));
    }

    @Test
    public void whenComparatorByNameDecrease() {
        List<User> expected = new ArrayList<>(
                List.of(
                        new User("Gleb", 3),
                        new User("Boris", 2),
                        new User("Anton", 1)
                )
        );
        List<User> result = new ArrayList<>(
                List.of(
                        new User("Boris", 2),
                        new User("Gleb", 3),
                        new User("Anton", 1)
                )
        );
        result.sort(new UserDeByName());
        assertThat(result, is(expected));
    }

    @Test
    public void whenComparatorByPriorityIncrease() {
        List<User> expected = new ArrayList<>(
                List.of(
                        new User("Anton", 1),
                        new User("Boris", 2),
                        new User("Gleb", 3)
                )
        );
        List<User> result = new ArrayList<>(
                List.of(
                        new User("Boris", 2),
                        new User("Gleb", 3),
                        new User("Anton", 1)
                )
        );
        result.sort(new UserInByPriority());
        assertThat(result, is(expected));
    }

    @Test
    public void whenComparatorByPriorityDecrease() {
        List<User> expected = new ArrayList<>(
                List.of(
                        new User("Gleb", 3),
                        new User("Boris", 2),
                        new User("Anton", 1)
                )
        );
        List<User> result = new ArrayList<>(
                List.of(
                        new User("Boris", 2),
                        new User("Gleb", 3),
                        new User("Anton", 1)
                )
        );
        result.sort(new UserDeByPriority());
        assertThat(result, is(expected));
    }

    @Test
    public void whenComparatorByNameAndPriorityIn() {
        Comparator<User> cmpNamePriority = new UserInByName().thenComparing(new UserInByPriority());
        int rsl = cmpNamePriority.compare(
                new User("Impl task", 0),
                new User("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityDe() {
        Comparator<User> cmpNamePriority = new UserDeByName().thenComparing(new UserDeByPriority());
        int rsl = cmpNamePriority.compare(
                new User("Impl task", 0),
                new User("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}