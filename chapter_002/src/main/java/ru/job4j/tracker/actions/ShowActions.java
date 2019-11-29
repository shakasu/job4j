package ru.job4j.tracker.actions;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class ShowActions extends BaseAction {
    public ShowActions(int key, String name) {
        super(key, name);
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
