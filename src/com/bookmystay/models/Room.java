package com.bookmystay.models;

/**
 * UC2 - Abstract Room Class
 *
 * Goal: Demonstrate abstraction and encapsulation before introducing data structures.
 *
 * Key Concepts:
 *  - Abstract Class: Cannot be instantiated directly. Defines common structure for all rooms.
 *  - Encapsulation: Attributes are protected; accessible only via methods.
 *  - Polymorphism: Enables uniform handling of different room types via Room reference.
 */
public abstract class Room {

    protected String roomNumber;
    protected int    numberOfBeds;
    protected double sizeInSqft;
    protected double pricePerNight;

    public Room(String roomNumber, int numberOfBeds, double sizeInSqft, double pricePerNight) {
        this.roomNumber    = roomNumber;
        this.numberOfBeds  = numberOfBeds;
        this.sizeInSqft    = sizeInSqft;
        this.pricePerNight = pricePerNight;
    }

    // Enforces specialization: every room type must provide its own description
    public abstract String getRoomDescription();

    public String getRoomNumber()    { return roomNumber;      }
    public int    getNumberOfBeds()  { return numberOfBeds;    }
    public double getSizeInSqft()    { return sizeInSqft;      }
    public double getPricePerNight() { return pricePerNight;   }

    @Override
    public String toString() {
        return String.format("[%s] %-12s | Beds: %d | %6.0f sqft | $%.2f/night",
                roomNumber, getRoomDescription(), numberOfBeds, sizeInSqft, pricePerNight);
    }
}
