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
    private static final String LN = System.lineSeparator();
    private String menu = String.format("0. Add new item.%s%s1. Show all items.%s%s2. Edit item.%s%s3. Delete item.%s%s4. Find by Id.%s%s5. Find by name.%s%s6. Exit%s%s", LN, LN, LN, LN, LN, LN, LN, LN, LN, LN, LN, LN, LN, LN);

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenShowMenu() {
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker, output).init();
        assertThat(new String(this.out.toByteArray()), is(menu));
    }

    @Test
    public void createActionTest() {
        Input input = new StubInput(new String[] {"0", "tes2", "6"});
        new StartUI(input, tracker, output).init();
        String name = tracker.findAll().get(0).getName();
        String id = tracker.findAll().get(0).getId();
        String rsl = String.format("%sAdding item was successful.%sName - %s and Id - %s of new item%s%s%s", menu, LN, name, id, LN, LN, menu);
        assertThat(new String(this.out.toByteArray()), is(rsl));
}

    @Test
    public void showAll() {
        Item item1 = tracker.add(new Item("test1", 12));
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%s%s - %s%s%s%s", menu, item1.getName(), item1.getId(), LN, LN, menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }

    @Test
    public void editActionTest() {
        Item item1 = tracker.add(new Item("test1", 123));
        Input input = new StubInput(new String[] {"2", item1.getId(), "test2", "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%sEditing successfully done - test2 Id - %s%s%s%s", menu, item1.getId(), LN, LN, menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }

    @Test
    public void deleteActionTest() {
        Item item1 = tracker.add(new Item("test1", 123));
        String itemId = item1.getId();
        Input input = new StubInput(new String[] {"3", itemId, "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%sItem deleted successfully%sNow item with Id %s not exist%s%s%s", menu, LN, item1.getId(), LN, LN, menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }

    @Test
    public void findById() {
        Item item1 = tracker.add(new Item("test1", 123));
        String itemId = item1.getId();
        Input input = new StubInput(new String[] {"4", itemId, "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%stest1 is required element.%s%s%s", menu, LN, LN, menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }

    @Test
    public void findByName() {
        Item item1 = tracker.add(new Item("test1", 123));
        Input input = new StubInput(new String[] {"5", item1.getName(), "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%stest1 - %s%s%s%s", menu, item1.getId(), LN, LN, menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }
}
