package com.bookmystay.services;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.models.Reservation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BookingService {
    // Map room types to allocated unique Room IDs
    private Map<String, Set<String>> allocatedRooms;

    public BookingService() {
        this.allocatedRooms = new HashMap<>();
    }

    public void processQueue(BookingRequestQueue queue, RoomInventory inventory) {
        System.out.println("--- Processing Booking Queue ---");
        while (!queue.isEmpty()) {
            Reservation req = queue.dequeue();
            boolean success = allocateRoom(req, inventory);
            if (success) {
                System.out.println("[SUCCESS] Allocated room for " + req.getGuestName() + "\n");
            } else {
                System.out.println("[FAILED] Could not allocate room for " + req.getGuestName() + ". No availability.\n");
            }
        }
    }

    private boolean allocateRoom(Reservation request, RoomInventory inventory) {
        String type = request.getRoomType();
        int available = inventory.getAvailableCount(type);

        if (available > 0) {
            // Generate Unique Room ID
            String roomId = type.substring(0, 1).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 5);
            
            // Record allocation to prevent double-booking
            allocatedRooms.putIfAbsent(type, new HashSet<>());
            Set<String> typeAllocations = allocatedRooms.get(type);

            // Defensive check against double booking (Set enforcement)
            if (typeAllocations.contains(roomId)) {
                System.out.println("[ERROR] Room ID collision! Double booking prevented.");
                return false;
            }

            typeAllocations.add(roomId);
            
            // Deduct availability atomically with allocation
            inventory.decreaseAvailability(type);

            System.out.println("[CONFIRMED] " + request.getGuestName() + " assigned Room ID: " + roomId);
            return true;
        }

        return false;
    }

    public void displayAllocations() {
        System.out.println("--- Current Room Allocations ---");
        for (Map.Entry<String, Set<String>> entry : allocatedRooms.entrySet()) {
            System.out.println(entry.getKey() + " Rooms Allocated: " + entry.getValue());
        }
    }
}
