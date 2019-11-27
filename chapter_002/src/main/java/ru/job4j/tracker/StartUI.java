package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name =  input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Adding item was successful.");
        System.out.println("Name and Id of new item - " + item.getName() + " - " + item.getId());
    }
    public static void showAll(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        for (Item item : tracker.findAll()) {
            if (item != null) {
                System.out.println(item.getName() + " - " + item.getId());
            }
        }
    }
    public static  void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String idItem =  input.askStr("Enter the Id of the old item");
        System.out.println("Enter the name of the new item");
        String newItemName =  input.askStr("");
        Item newItem = new Item(newItemName);
        if (tracker.replace(idItem, newItem)) {
        System.out.println("Editing successfully done");
        } else {
            System.out.println("Item not found");
        }
    }
    public static  void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String idItem =  input.askStr("Enter the Id of the item to delete.");
        if (tracker.delete(idItem)) {
            System.out.println("Item deleted successfully");
        } else {
            System.out.println("Item not found");
        }
    }
    public static  void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String idItem =  input.askStr("Enter the Id of the item to search for.");
        Item requiredItem = tracker.findById(idItem);
        if (requiredItem != null) {
            System.out.println(requiredItem.getName() + " is required element.");
        } else {
            System.out.println("Item not found");
        }
    }
    public static  void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ====");
        for (Item item : tracker.findByName(input.askStr("Enter the name of the item to search for."))) {
            if (item != null) {
                System.out.println(item.getName() + " - " + item.getId());
            }
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select: "));
            final boolean[] IS_IT = new boolean[7];
            IS_IT[select] = true;
            if (IS_IT[0]) {
                StartUI.createItem(input, tracker);
                IS_IT[select] = false;
            } else if (IS_IT[1]) {
                StartUI.showAll(input, tracker);
                IS_IT[select] = false;
            } else if (IS_IT[2]) {
                StartUI.editItem(input, tracker);
                IS_IT[select] = false;
            } else if (IS_IT[3]) {
                StartUI.deleteItem(input, tracker);
                IS_IT[select] = false;
            } else if (IS_IT[4]) {
                StartUI.findById(input, tracker);
                IS_IT[select] = false;
            } else if (IS_IT[5]) {
                StartUI.findByName(input, tracker);
                IS_IT[select] = false;
            } else if (IS_IT[6]) {
                run = false;
                IS_IT[select] = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}