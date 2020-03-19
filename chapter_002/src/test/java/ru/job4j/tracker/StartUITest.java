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
    private String menu = "0. Add new item.\r\n\r\n"
            + "1. Show all items.\r\n\r\n"
            + "2. Edit item.\r\n\r\n"
            + "3. Delete item.\r\n\r\n"
            + "4. Find by Id.\r\n\r\n"
            + "5. Find by name.\r\n\r\n"
            + "6. Exit\r\n\r\n";

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
        assertThat(new String(this.out.toByteArray()), is(menu + "Adding item was successful.\r\nName - " + name + " and Id - " + id + " of new item\r\n\r\n" + menu));
    }

    @Test
    public void showAll() {
        Item item1 = tracker.add(new Item("test1", 12));
        Input input = new StubInput(new String[] {"1", "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%s%s - %s\r\n\r\n%s", menu, item1.getName(), item1.getId(), menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }

    @Test
    public void editActionTest() {
        Item item1 = tracker.add(new Item("test1", 123));
        Input input = new StubInput(new String[] {"2", item1.getId(), "test2", "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%sEditing successfully done - test2 Id - %s\r\n\r\n%s", menu, item1.getId(), menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }

    @Test
    public void deleteActionTest() {
        Item item1 = tracker.add(new Item("test1", 123));
        String itemId = item1.getId();
        Input input = new StubInput(new String[] {"3", itemId, "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%sItem deleted successfully\r\nNow item with Id %s not exist\r\n\r\n%s", menu, item1.getId(), menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }

    @Test
    public void findById() {
        Item item1 = tracker.add(new Item("test1", 123));
        String itemId = item1.getId();
        Input input = new StubInput(new String[] {"4", itemId, "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%stest1 is required element.\r\n\r\n%s", menu, menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }

    @Test
    public void findByName() {
        Item item1 = tracker.add(new Item("test1", 123));
        Input input = new StubInput(new String[] {"5", item1.getName(), "6"});
        new StartUI(input, tracker, output).init();
        String rsl = String.format("%stest1 - %s\r\n\r\n%s", menu, item1.getId(), menu);
        assertThat(rsl, is(new String(this.out.toByteArray())));
    }
}
