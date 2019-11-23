package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                for (Item item : tracker.findAll()) {
                    if (item != null) {
                        System.out.println(item.getName());
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Enter the Id of the old item");
                String itemId = scanner.nextLine();
                System.out.println("Enter the name of the new item");
                String newItemName = scanner.nextLine();
                Item newItem = new Item(newItemName);
                tracker.replace(itemId, newItem);
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Enter the Id of the item to delete.");
                String idItem = scanner.nextLine();
                System.out.println("Delete is " + tracker.delete(idItem));
                tracker.delete(idItem);
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.println("Enter the Id of the item to search for.");
                String idItem = scanner.nextLine();
                System.out.println(tracker.findById(idItem).getName());
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.println("Enter the name of the item to search for.");
                for (Item item : tracker.findByName(scanner.nextLine())) {
                    if (item != null) {
                        System.out.println(item.getName());
                    }
                }
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        /*Item test1 = new Item("test1");
        tracker.add(test1);
        Item test2 = new Item("test2");
        tracker.add(test2);
        Item test3 = new Item("test3");
        tracker.add(test3);
        test1.setId("1");
        test2.setId("2");
        test3.setId("3");*/
        new StartUI().init(scanner, tracker);
    }
}