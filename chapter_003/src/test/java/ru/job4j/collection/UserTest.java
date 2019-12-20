package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
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
    public void whenComporatorByNameIncrease() {
        List<User> expected = new ArrayList<>();
        List<User> result = new ArrayList<>();
        User user1 = new User("Anton", 1);
        User user2 = new User("Boris", 2);
        User user3 = new User("Gleb", 3);
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);
        result.add(user2);
        result.add(user3);
        result.add(user1);
        Collections.sort(result, new UserInByName());
        assertThat(result, is(expected));
    }

    @Test
    public void whenComporatorByNameDecrease() {
        List<User> expected = new ArrayList<>();
        List<User> result = new ArrayList<>();
        User user1 = new User("Anton", 1);
        User user2 = new User("Boris", 2);
        User user3 = new User("Gleb", 3);
        expected.add(user3);
        expected.add(user2);
        expected.add(user1);
        result.add(user2);
        result.add(user3);
        result.add(user1);
        Collections.sort(result, new UserDeByName());
        assertThat(result, is(expected));
    }

    @Test
    public void whenComporatorByPriorityIncrease() {
        List<User> expected = new ArrayList<>();
        List<User> result = new ArrayList<>();
        User user1 = new User("Anton", 1);
        User user2 = new User("Boris", 2);
        User user3 = new User("Gleb", 3);
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);
        result.add(user2);
        result.add(user3);
        result.add(user1);
        Collections.sort(result, new UserInByPriority());
        assertThat(result, is(expected));
    }

    @Test
    public void whenComporatorByPriorityDecrease() {
        List<User> expected = new ArrayList<>();
        List<User> result = new ArrayList<>();
        User user1 = new User("Anton", 1);
        User user2 = new User("Boris", 2);
        User user3 = new User("Gleb", 3);
        expected.add(user3);
        expected.add(user2);
        expected.add(user1);
        result.add(user2);
        result.add(user3);
        result.add(user1);
        Collections.sort(result, new UserDeByPriority());
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