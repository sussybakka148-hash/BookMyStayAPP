package com.bookmystay.services;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.models.Room;

import java.util.List;

public class SearchService {

    public void searchAvailableRooms(RoomInventory inventory, List<Room> roomCatalog) {
        System.out.println("--- Search Results (Read-Only) ---");
        boolean found = false;

        for (Room room : roomCatalog) {
            String type = room.getClass().getSimpleName().replace("Room", "");
            int availableCount = inventory.getAvailableCount(type);

            if (availableCount > 0) {
                System.out.printf("%-10s | Price: $%.2f/night | Beds: %d | Available: %d%n",
                        type, room.getPricePerNight(), room.getNumberOfBeds(), availableCount);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms available at the moment.");
        }
    }
}
