package com.bookmystay;

import com.bookmystay.models.DoubleRoom;
import com.bookmystay.models.Room;
import com.bookmystay.models.SingleRoom;
import com.bookmystay.models.SuiteRoom;

/**
 * UC2 - Room Modeling with Inheritance & Polymorphism
 *
 * Goal: Introduce object modeling through inheritance and abstraction.
 *
 * Flow:
 *  1. User runs the application.
 *  2. Room objects of different types are created as concrete subclasses.
 *  3. Availability is stored in simple boolean variables (intentional limitation).
 *  4. Room details and availability are printed via polymorphic Room reference.
 *
 * NOTE: Scattered boolean variables for availability highlight the problem
 * that UC3 solves using a centralized HashMap.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("  BookMyStay - UC2: Room Modeling");
        System.out.println("============================================\n");

        // Polymorphism: Room[] stores different concrete types uniformly
        Room[] rooms = {
            new SingleRoom("101"),
            new SingleRoom("102"),
            new DoubleRoom("201"),
            new DoubleRoom("202"),
            new SuiteRoom("301")
        };

        // Availability via scattered variables — intentional design limitation
        // Problem: adding a 6th room means adding another variable manually
        boolean room101Available = true;
        boolean room102Available = false;
        boolean room201Available = true;
        boolean room202Available = true;
        boolean room301Available = false;

        boolean[] availability = {
            room101Available, room102Available,
            room201Available, room202Available,
            room301Available
        };

        System.out.println("--- Room Details & Availability ---");
        for (int i = 0; i < rooms.length; i++) {
            String status = availability[i] ? "AVAILABLE" : "OCCUPIED";
            System.out.println(rooms[i] + " | Status: " + status);
        }

        System.out.println();
        System.out.println("[LIMITATION] Availability is scattered across individual variables.");
        System.out.println("[NEXT]       UC3 introduces HashMap to centralize this as a single source of truth.");
    }
}
