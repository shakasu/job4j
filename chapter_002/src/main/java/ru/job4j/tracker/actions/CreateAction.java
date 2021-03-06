package ru.job4j.tracker.actions;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class CreateAction extends BaseAction {
    public CreateAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.accept(String.format("Adding item was successful.%nName - %s and Id - %s of new item%n", item.getName(), item.getId()));
        return true;
    }
}
