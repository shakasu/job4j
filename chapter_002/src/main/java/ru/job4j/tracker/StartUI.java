package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

public class StartUI {

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (UserAction action : actions) {
            System.out.printf(action.info());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        BaseAction[] actions = {
                new CreateAction(0, "Add new item."),
                new ShowActions(1, "Show all items."),
                new EditAction(2, "Edit item."),
                new DeleteAction(3, "Delete item."),
                new FindActionById(4, "Find by Id."),
                new FindActionByName(5, "Find by name."),
                new ExitAction(6, "Exit")
        };
        new StartUI().init(validate, tracker, actions);
    }
}