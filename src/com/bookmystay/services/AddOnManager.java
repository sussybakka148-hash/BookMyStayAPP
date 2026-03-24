package com.bookmystay.services;

import com.bookmystay.models.AddOnService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnManager {
    // Maps Reservation ID or Room ID to a list of selected optional services
    private Map<String, List<AddOnService>> reservationAddOns;

    public AddOnManager() {
        this.reservationAddOns = new HashMap<>();
    }

    public void addServiceToReservation(String reservationId, AddOnService service) {
        reservationAddOns.putIfAbsent(reservationId, new ArrayList<>());
        reservationAddOns.get(reservationId).add(service);
        System.out.println("[ADD-ON] Added " + service.getServiceName() + " to Reservation ID: " + reservationId);
    }

    public double calculateTotalAddOnCost(String reservationId) {
        List<AddOnService> services = reservationAddOns.getOrDefault(reservationId, new ArrayList<>());
        double total = 0.0;
        for (AddOnService service : services) {
            total += service.getPrice();
        }
        return total;
    }

    public void displayAddOns(String reservationId) {
        List<AddOnService> services = reservationAddOns.getOrDefault(reservationId, new ArrayList<>());
        System.out.println("--- Add-Ons for " + reservationId + " ---");
        if (services.isEmpty()) {
            System.out.println("No add-ons selected.");
        } else {
            for (AddOnService service : services) {
                System.out.println("- " + service);
            }
            System.out.println("Total Add-On Cost: $" + calculateTotalAddOnCost(reservationId));
        }
    }
}
