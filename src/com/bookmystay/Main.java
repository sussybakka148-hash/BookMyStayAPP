package com.bookmystay;

import com.bookmystay.models.DoubleRoom;
import com.bookmystay.models.Room;
import com.bookmystay.models.SingleRoom;
import com.bookmystay.models.SuiteRoom;
import com.bookmystay.inventory.RoomInventory;

/**
 * UC3 - Centralized Inventory Management
 *
 * Goal: Centralize availability state using a HashMap.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  BookMyStay - UC3: Centralized Inventory");
        System.out.println("============================================\n");

        System.out.println("[INIT] Initializing Centralized Inventory System...");
        RoomInventory inventory = new RoomInventory();
        
        // Registering rooms to our centralized HashMap
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 3);
        inventory.addRoomType("Suite", 2);

        System.out.println("\n--- Current Inventory ---");
        inventory.displayInventory();

        System.out.println("\n[DEMO] Updating inventory. Someone booked a Double room...");
        if (inventory.decreaseAvailability("Double")) {
            System.out.println("Update successful. Room reserved logically.");
        }

        System.out.println("\n--- Updated Inventory ---");
        inventory.displayInventory();
        
        System.out.println("\n[NOTE] Availability mapping is now centralized and single-source-of-truth.");
        System.out.println("[NEXT] UC4 will introduce Safe Read-Only Search capabilities.");
    }
}
