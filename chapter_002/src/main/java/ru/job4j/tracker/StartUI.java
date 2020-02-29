package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        boolean run = true;
        while (run) {
            menu.show();
            run = menu.select(input.askInt("Select: ", menu.size()));
        }
    }

    public static void main(String[] args) {
       new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}