package ru.job4j.tracker.actions;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class EditAction extends BaseAction {
    public EditAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idItem =  input.askStr("Enter the Id of the old item");
        String newItemName =  input.askStr("Enter the name of the new item");
        Item newItem = new Item(newItemName);
        if (tracker.replace(idItem, newItem)) {
            System.out.printf("Editing successfully done - %s Id - %s%n", newItem.getName(), newItem.getId());
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
