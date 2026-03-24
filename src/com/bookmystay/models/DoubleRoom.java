package com.bookmystay.models;

/** UC2 - Concrete Double Room. Inherits from abstract Room. */
public class DoubleRoom extends Room {
    public DoubleRoom(String roomNumber) {
        super(roomNumber, 2, 350.0, 130.0);
    }

    @Override
    public String getRoomDescription() {
        return "Double Room";
    }
}
