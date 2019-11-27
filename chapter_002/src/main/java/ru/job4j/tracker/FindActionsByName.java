package ru.job4j.tracker;

public class FindActionsByName implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findByName(input.askStr("Enter the name of the item to search for."))) {
            if (item != null) {
                System.out.printf("%s - %s%n",item.getName(), item.getId());            }
        }
        return true;
    }
}
