package com.bookmystay;

import com.bookmystay.models.Room;
import com.bookmystay.services.InventoryService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Hotel Booking Management System...");

        InventoryService inventoryService = new InventoryService();

        // 1. Initialize some rooms
        inventoryService.addRoom(new Room("101", "Single", 100.0));
        inventoryService.addRoom(new Room("102", "Double", 150.0));
        inventoryService.addRoom(new Room("201", "Suite", 300.0));

        // 2. Simple Console Menu for Phase 1
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View All Rooms");
            System.out.println("2. View Available Rooms");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inventoryService.displayInventory();
                    break;
                case "2":
                    System.out.println("--- Available Rooms ---");
                    for (Room room : inventoryService.getAvailableRooms()) {
                        System.out.println(room);
                    }
                    System.out.println("-----------------------");
                    break;
                case "3":
                    System.out.println("Exiting System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
