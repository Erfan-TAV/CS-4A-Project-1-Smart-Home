package org.cs4a.project1;

import org.cs4a.project1.exceptions.DeviceNotFoundException;
import org.cs4a.project1.exceptions.RoomNotFoundException;

import java.util.Objects;
import java.util.Vector;

public class Room {
    private String name;
    private int roomID;
    private Vector<Device> deviceList;

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

    public Vector<Device> getDeviceList() {
        return deviceList;
    }

    // DeviceInactiveException if not active
    public boolean addDeviceToRoom(Device newDevice) throws RoomNotFoundException {
        if (!newDevice.isActive()) {
            throw new RoomNotFoundException(name);
        }
        return deviceList.add(newDevice);
    }

    // RoomNotFoundException if device not in room
    public Device removeDeviceFromRoom(final String deviceName) throws DeviceNotFoundException {
        for (int i = 0; i < deviceList.size(); i++) {
            if (Objects.equals(deviceList.get(i).getName(), deviceName)) {
                return deviceList.remove(i);
            }
        }
        throw new DeviceNotFoundException(deviceName);
    }
}
