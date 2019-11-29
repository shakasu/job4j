package ru.job4j.tracker.actions;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

public class DeleteAction extends BaseAction {
    public DeleteAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idItem =  input.askStr("Enter the Id of the item to delete.");
        if (tracker.delete(idItem)) {
            System.out.printf("Item deleted successfully%nNow item with Id %s not exist%n", idItem);
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
