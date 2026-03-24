package com.bookmystay;

import com.bookmystay.inventory.RoomInventory;
import com.bookmystay.models.AddOnService;
import com.bookmystay.models.Reservation;
import com.bookmystay.services.AddOnManager;
import com.bookmystay.services.BookingRequestQueue;
import com.bookmystay.services.BookingService;

/**
 * UC7 - Optional Services
 *
 * Goal: Extend the booking model to support optional services, demonstrating 
 * how real-world business features can be added without modifying core logic.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  BookMyStay - UC7: Optional Add-on Services");
        System.out.println("============================================\n");

        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Suite", 5);

        BookingRequestQueue queue = new BookingRequestQueue();
        queue.enqueue(new Reservation("Eve", "Suite"));

        System.out.println();
        BookingService bookingService = new BookingService();
        bookingService.processQueue(queue, inventory);

        // Assume we know the generated Room ID for Eve (for demo purposes we simulate a known ID)
        String mockReservationId = "RES-12345";
        System.out.println("[INFO] Eve's Reservation ID is " + mockReservationId + "\n");

        System.out.println("--- Adding Optional Services ---");
        AddOnManager addOnManager = new AddOnManager();
        
        AddOnService breakfast = new AddOnService("Breakfast Buffet", 25.0);
        AddOnService spa = new AddOnService("Spa Access", 75.0);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 50.0);

        addOnManager.addServiceToReservation(mockReservationId, breakfast);
        addOnManager.addServiceToReservation(mockReservationId, spa);
        addOnManager.addServiceToReservation(mockReservationId, airportPickup);

        System.out.println();
        addOnManager.displayAddOns(mockReservationId);

        System.out.println("\n[COMPLETED] BookMyStay core logic (UC1-UC7) is fully implemented.");
    }
}
