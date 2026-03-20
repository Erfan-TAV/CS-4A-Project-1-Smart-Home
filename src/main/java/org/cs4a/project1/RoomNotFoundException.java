package org.cs4a.project1;

public class RoomNotFoundException extends Exception {

    public RoomNotFoundException(int roomID) {
        super("Room not found: no room with ID " + roomID + " exists.");
    }

    public RoomNotFoundException(String roomName) {
        super("Room not found: no room named \"" + roomName + "\" exists.");
    }
}
