package ru.job4j.tracker;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
    private final Tracker tracker = new Tracker();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void createActionTest() {
        Input input = new StubInput(new String[] {"0", "tes2", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("tes2"));
    }

    @Test
    public void deleteActionTest() {
        Item item1 = tracker.add(new Item("test1", 123));
        Item item2 = tracker.add(new Item("test2", 12));
        Input input = new StubInput(new String[] {"3", item1.getId(), "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getId(), is(item2.getId()));
    }

    @Test
    public void editActionTest() {
        Item item1 = tracker.add(new Item("test1", 123));
        Input input = new StubInput(new String[] {"2", item1.getId(), "test2", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test2"));
    }
}
