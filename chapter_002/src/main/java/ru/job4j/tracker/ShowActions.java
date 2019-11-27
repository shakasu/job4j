package ru.job4j.tracker;

public class ShowActions implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            if (item != null) {
                System.out.printf("%s - %s%n",item.getName(), item.getId());
            }
        }
        return true;
    }
}
