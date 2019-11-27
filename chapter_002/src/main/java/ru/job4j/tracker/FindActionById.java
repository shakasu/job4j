package ru.job4j.tracker;

public class FindActionById implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idItem =  input.askStr("Enter the Id of the item to search for.");
        Item requiredItem = tracker.findById(idItem);
        if (requiredItem != null) {
            System.out.printf("%s is required element.%n", requiredItem.getName());
        } else {
            System.out.println("Item not found");
        }
        return true;
    }
}
