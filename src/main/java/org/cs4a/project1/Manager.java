package org.cs4a.project1;

import java.util.Objects;
import java.util.Vector;

public class Manager {
    private Vector<Room> roomList;

    public Vector<Room> getRoomList() {
        return roomList;
    }

    public Room getRoom(final int roomID) {
        for (Room room : roomList) {
            if (room.getRoomID() == roomID) {
                return room;
            }
        }
        return null;
    }
    public Room getRoom(final String roomName) {
        for (Room room : roomList) {
            if (Objects.equals(room.getName(), roomName)) {
                return room;
            }
        }
        return null;
    }

    public boolean addRoom(Room newRoom) {
        return roomList.add(newRoom);
    }

    public Room removeRoom(final int roomID) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomID() == roomID) {
                return roomList.remove(i);
            }
        }
        return null;
    }
    public Room removeRoom(final String roomName) {
        for (int i = 0; i < roomList.size(); i++) {
            if (Objects.equals(roomList.get(i).getName(), roomName)) {
                return roomList.remove(i);
            }
        }
        return null;
    }
}