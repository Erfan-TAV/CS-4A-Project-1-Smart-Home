package org.cs4a.project1;

import java.util.Objects;
import java.util.Vector;

public class Manager {
    private Vector<Room> roomList;

    public Vector<Room> getRoomList() {
        return roomList;
    }

    public Room getRoom(final int roomID) throws RoomNotFoundException {
        for (Room room : roomList) {
            if (room.getRoomID() == roomID) {
                return room;
            }
        }
        throw new RoomNotFoundException(roomID);
    }
    public Room getRoom(final String roomName) throws RoomNotFoundException {
        for (Room room : roomList) {
            if (Objects.equals(room.getName(), roomName)) {
                return room;
            }
        }
        throw new RoomNotFoundException(roomName);
    }

    public boolean addRoom(Room newRoom) {
        return roomList.add(newRoom);
    }

    public Room removeRoom(final int roomID) throws RoomNotFoundException {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomID() == roomID) {
                return roomList.remove(i);
            }
        }
        throw new RoomNotFoundException(roomID);
    }
    public Room removeRoom(final String roomName) throws RoomNotFoundException {
        for (int i = 0; i < roomList.size(); i++) {
            if (Objects.equals(roomList.get(i).getName(), roomName)) {
                return roomList.remove(i);
            }
        }
        throw new RoomNotFoundException(roomName);
    }
}
