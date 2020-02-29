package ru.job4j.tracker;

import org.junit.Test;
import java.io.PrintStream;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final Tracker tracker = new Tracker();
    private final Item item = tracker.add(new Item("tes1", 12));
    private PrintStream out = System.out;

    private final Consumer<String> output = new Consumer<>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    /*private final String menu = new StringJoiner(System.lineSeparator())
            .add("0. Add new item.")
            .add("1. Show all items.")
            .add("2. Edit item.")
            .add("3. Delete item.")
            .add("4. Find by Id.")
            .add("5. Find by name.")
            .add("6. Exit")
            .toString();*/

    @Test
    public void createActionTest() {
        Input input = new StubInput(new String[] {"0", "tes2"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(1).getName(), is("tes2"));
    }

    @Test
    public void deleteActionTest() {

    }

    @Test
    public void editActionTest() {

    }

    @Test
    public void exitActionTest() {

    }

    @Test
    public void findActionByIdTest() {
        Input input = new StubInput(new String[] {"4", item.getId()});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()).getName(), is("tes1"));
    }

    @Test
    public void findActionByNameTest() {

    }

    @Test
    public void showActionsTest() {
        Input input = new StubInput(new String[] {"1"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("tes1"));
    }
}
