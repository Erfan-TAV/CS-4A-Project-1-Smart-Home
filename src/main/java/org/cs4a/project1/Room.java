package org.cs4a.project1;

import java.util.Vector;

public class Room {
    private String name;
    private int roomID;
    private Vector<Object> deviceList;

    public String getName() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }

    public int getRoomID() {
        return roomID;
    }
    public void setRoomID(final int newRoomID) {
        roomID = newRoomID;
    }

    public Vector<Object> getDeviceList() {
        return deviceList;
    }
    public boolean addDeviceToRoom(Device newDevice) {
        return deviceList.add(newDevice);
    }
    public Object removeDeviceFromRoom(final int deviceID) {
        return deviceList.remove(deviceID);
    }
}
