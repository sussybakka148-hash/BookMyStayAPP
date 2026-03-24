package com.bookmystay;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.models.DoubleRoom;
import com.bookmystay.models.Room;
import com.bookmystay.models.SingleRoom;
import com.bookmystay.models.SuiteRoom;
import com.bookmystay.services.SearchService;

import java.util.Arrays;
import java.util.List;

/**
 * UC4 - Search Availability (Read-Only Access)
 *
 * Goal: Enable guests to view available rooms and their details without modifying 
 * system state, reinforcing safe data access and clear separation of responsibilities.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  BookMyStay - UC4: Search Availability");
        System.out.println("============================================\n");

        System.out.println("[INIT] Setting up Inventory...");
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 5);
        inventory.addRoomType("Double", 0); // Intentionally zero to show filtering
        inventory.addRoomType("Suite", 2);

        // A mock catalog to easily retrieve property values from domain models
        List<Room> catalog = Arrays.asList(
            new SingleRoom("N/A"),
            new DoubleRoom("N/A"),
            new SuiteRoom("N/A")
        );

        System.out.println("\n[DEMO] Initiating Search (Notice Double is NOT displayed)...");
        SearchService searchService = new SearchService();
        searchService.searchAvailableRooms(inventory, catalog);

        System.out.println("\n[NEXT] UC5 introduces Booking Request Queue to handle multiple booking requests.");
    }
}
