package ru.job4j.tracker;

public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name =  input.askStr("");
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
        System.out.println("Enter the Id of the old item");
        String idItem =  input.askStr("");
        while (tracker.findById(idItem) == null) {
            System.out.println("Id not found, please, try again. Your Id is?");
            idItem =  input.askStr("");
        }
        System.out.println("Enter the name of the new item");
        String newItemName =  input.askStr("");
        Item newItem = new Item(newItemName);
        tracker.replace(idItem, newItem);
        System.out.println("Editing successfully done");
    }
    public static  void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        System.out.println("Enter the Id of the item to delete.");
        String idItem =  input.askStr("");
        while (tracker.findById(idItem) == null) {
            System.out.println("Id not found, please, try again. Your Id is?");
            idItem =  input.askStr("");
        }
        if (tracker.delete(idItem)) {
            tracker.delete(idItem);
            System.out.println("Item deleted successfully");
        }
    }
    public static  void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        System.out.println("Enter the Id of the item to search for.");
        String idItem =  input.askStr("");
        while (tracker.findById(idItem) == null) {
            System.out.println("Id not found, please, try again. Your Id is?");
            idItem =  input.askStr("");
        }
        System.out.println(tracker.findById(idItem).getName() + " is required element.");
    }
    public static  void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ====");
        System.out.println("Enter the name of the item to search for.");
        for (Item item : tracker.findByName( input.askStr(""))) {
            if (item != null) {
                System.out.println(item.getName() + " - " + item.getId());
            }
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(input.askStr(""));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAll(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findById(input, tracker);
            } else if (select == 5) {
                StartUI.findByName(input, tracker);
            } else if (select == 6) {
                run = false;
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