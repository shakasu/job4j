package ru.job4j.tracker;

import ru.job4j.tracker.actions.*;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name =  input.askStr("Enter name:");
        Item item = new Item(name);
        tracker.add(item);
        System.out.printf("Adding item was successful.%nName - %s and Id - %s of new item%n", item.getName(), item.getId());
    }
    public static void showAll(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        for (Item item : tracker.findAll()) {
            if (item != null) {
                System.out.printf("%s - %s%n",item.getName(), item.getId());
            }
        }
    }
    public static  void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String idItem =  input.askStr("Enter the Id of the old item");
        String newItemName =  input.askStr("Enter the name of the new item");
        Item newItem = new Item(newItemName);
        if (tracker.replace(idItem, newItem)) {
        System.out.printf("Editing successfully done - %s Id - %s%n", newItem.getName(), newItem.getId());
        } else {
            System.out.println("Item not found");
        }
    }
    public static  void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String idItem =  input.askStr("Enter the Id of the item to delete.");
        if (tracker.delete(idItem)) {
            System.out.printf("Item deleted successfully%nNow item with Id %s not exist%n", idItem);
        } else {
            System.out.println("Item not found");
        }
    }
    public static  void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String idItem =  input.askStr("Enter the Id of the item to search for.");
        Item requiredItem = tracker.findById(idItem);
        if (requiredItem != null) {
            System.out.printf("%s is required element.%n", requiredItem.getName());
        } else {
            System.out.println("Item not found");
        }
    }
    public static  void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ====");
        for (Item item : tracker.findByName(input.askStr("Enter the name of the item to search for."))) {
            if (item != null) {
                System.out.printf("%s - %s%n",item.getName(), item.getId());            }
        }
    }

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