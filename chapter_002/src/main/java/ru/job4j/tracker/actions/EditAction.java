package ru.job4j.tracker.actions;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class EditAction extends BaseAction {
    public EditAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        String idItem =  input.askStr("Enter the Id of the old item");
        String newItemName =  input.askStr("Enter the name of the new item");
        Item newItem = new Item(newItemName);
        if (tracker.replace(idItem, newItem)) {
            output.accept(String.format("Editing successfully done - %s Id - %s%n", newItem.getName(), newItem.getId()));
        } else {
            output.accept(String.format("Item not found"));
        }
        return true;
    }
}
