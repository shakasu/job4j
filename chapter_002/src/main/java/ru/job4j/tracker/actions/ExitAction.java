package ru.job4j.tracker.actions;

import ru.job4j.tracker.BaseAction;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class ExitAction extends BaseAction {
    public ExitAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker, Consumer<String> output) {
        return false;
    }
}
