package com.bookmystay;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.models.Reservation;
import com.bookmystay.services.BookingRequestQueue;
import com.bookmystay.services.BookingService;

/**
 * UC6 - Room Allocation and Booking Confirmation
 *
 * Goal: Confirm booking requests by assigning rooms safely while ensuring 
 * inventory consistency and preventing double-booking under all circumstances.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  BookMyStay - UC6: Room Allocation");
        System.out.println("============================================\n");

        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Single", 2); // Max 2 singles
        inventory.addRoomType("Double", 1);
        inventory.addRoomType("Suite", 1);

        BookingRequestQueue queue = new BookingRequestQueue();
        
        System.out.println("--- Enqueuing Requests ---");
        queue.enqueue(new Reservation("Alice", "Single"));
        queue.enqueue(new Reservation("Bob", "Single"));
        queue.enqueue(new Reservation("Charlie", "Single")); // Should fail (only 2 avail)
        queue.enqueue(new Reservation("Dave", "Suite"));
        System.out.println();

        System.out.println("--- Pre-Allocation Inventory ---");
        inventory.displayInventory();
        System.out.println();

        BookingService bookingService = new BookingService();
        bookingService.processQueue(queue, inventory);

        System.out.println("--- Post-Allocation Inventory ---");
        inventory.displayInventory();
        System.out.println();
        
        bookingService.displayAllocations();

        System.out.println("\n[NEXT] UC7 introduces Optional Add-On Services using Map of Lists.");
    }
}
