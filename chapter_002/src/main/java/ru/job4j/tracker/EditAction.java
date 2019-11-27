package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
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
