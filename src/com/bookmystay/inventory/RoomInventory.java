package com.bookmystay.inventory;

import java.util.HashMap;
import java.util.Map;

public class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        // HashMap for O(1) average lookup and clear separation of state
        this.inventory = new HashMap<>();
    }

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailableCount(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public boolean decreaseAvailability(String type) {
        int current = getAvailableCount(type);
        if (current > 0) {
            inventory.put(type, current - 1);
            return true;
        }
        return false;
    }

    public void displayInventory() {
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " Room | Available Count: " + entry.getValue());
        }
    }
}
