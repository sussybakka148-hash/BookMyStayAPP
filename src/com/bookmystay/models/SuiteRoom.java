package com.bookmystay.models;

/** UC2 - Concrete Suite Room. Inherits from abstract Room. */
public class SuiteRoom extends Room {
    public SuiteRoom(String roomNumber) {
        super(roomNumber, 2, 700.0, 350.0);
    }

    @Override
    public String getRoomDescription() {
        return "Suite Room";
    }
}
