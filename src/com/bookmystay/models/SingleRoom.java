package com.bookmystay.models;

/** UC2 - Concrete Single Room. Inherits from abstract Room. */
public class SingleRoom extends Room {
    public SingleRoom(String roomNumber) {
        super(roomNumber, 1, 200.0, 80.0);
    }

    @Override
    public String getRoomDescription() {
        return "Single Room";
    }
}
