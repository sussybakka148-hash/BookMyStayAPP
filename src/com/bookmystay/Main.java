package com.bookmystay;

import com.bookmystay.models.Reservation;
import com.bookmystay.services.BookingRequestQueue;

/**
 * UC5 - Booking Request Queue
 *
 * Goal: Handle multiple booking requests fairly by introducing a request 
 * intake mechanism that preserves arrival order, reflecting real-world 
 * booking behavior during peak demand.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  BookMyStay - UC5: Booking Request Queue");
        System.out.println("============================================\n");

        System.out.println("[INIT] Initializing Booking Request Queue...\n");
        BookingRequestQueue queue = new BookingRequestQueue();

        System.out.println("--- Guest Requests Incoming ---");
        // Simulate arriving requests
        queue.enqueue(new Reservation("Alice", "Single"));
        queue.enqueue(new Reservation("Bob", "Double"));
        queue.enqueue(new Reservation("Charlie", "Suite"));
        
        System.out.println();
        queue.displayQueueStatus();

        System.out.println("\n--- Processing Requests (FIFO behavior) ---");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        System.out.println();
        queue.displayQueueStatus();

        System.out.println("\n[NOTE] No inventory mutation occurs at this stage; we only sequenced the incoming requests.");
        System.out.println("[NEXT] UC6 combines the Queue with Inventory to perform safe allocations.");
    }
}
