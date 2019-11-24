package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Adding item was successful.");
                System.out.println("Name and Id of new item - " + item.getName() + " - " + item.getId());
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                for (Item item : tracker.findAll()) {
                    if (item != null) {
                        System.out.println(item.getName() + " - " + item.getId());
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Enter the Id of the old item");
                String idItem = scanner.nextLine();
                while (tracker.findById(idItem) == null) {
                    System.out.println("Id not found, please, try again. Your Id is?");
                    idItem = scanner.nextLine();
                }
                System.out.println("Enter the name of the new item");
                String newItemName = scanner.nextLine();
                Item newItem = new Item(newItemName);
                tracker.replace(idItem, newItem);
                System.out.println("Editing successfully done");
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Enter the Id of the item to delete.");
                String idItem = scanner.nextLine();
                while (tracker.findById(idItem) == null) {
                    System.out.println("Id not found, please, try again. Your Id is?");
                    idItem = scanner.nextLine();
                }
                if (tracker.delete(idItem)) {
                    tracker.delete(idItem);
                    System.out.println("Item deleted successfully");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.println("Enter the Id of the item to search for.");
                String idItem = scanner.nextLine();
                while (tracker.findById(idItem) == null) {
                    System.out.println("Id not found, please, try again. Your Id is?");
                    idItem = scanner.nextLine();
                }
                System.out.println(tracker.findById(idItem).getName() + " is required element.");
            } else if (select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.println("Enter the name of the item to search for.");
                for (Item item : tracker.findByName(scanner.nextLine())) {
                    if (item != null) {
                        System.out.println(item.getName() + " - " + item.getId());
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
        new StartUI().init(scanner, tracker);
    }
}