package ru.job4j.tracker.actions;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class FindActionByName extends BaseAction {
    public FindActionByName(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        for (Item item : tracker.findByName(input.askStr("Enter the name of the item to search for."))) {
            if (item != null) {
                output.accept(String.format("%s - %s%n", item.getName(), item.getId()));
            }
        }
        return true;
    }
}
