package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
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
