package com.bookmystay.services;

import com.bookmystay.models.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    // Map is used here for fast lookup by Room Number - O(1) time complexity
    private Map<String, Room> roomInventory;

    public InventoryService() {
        this.roomInventory = new HashMap<>();
    }

    public void addRoom(Room room) {
        if (!roomInventory.containsKey(room.getRoomNumber())) {
            roomInventory.put(room.getRoomNumber(), room);
        } else {
            System.out.println("Room " + room.getRoomNumber() + " already exists.");
        }
    }

    public Room getRoom(String roomNumber) {
        return roomInventory.get(roomNumber);
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(roomInventory.values());
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : roomInventory.values()) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void displayInventory() {
        System.out.println("--- Hotel Room Inventory ---");
        for (Room room : roomInventory.values()) {
            System.out.println(room);
        }
        System.out.println("----------------------------");
    }
}
