package org.cs4a.project1.exceptions;

public class DeviceNotFoundException extends RuntimeException {
    public DeviceNotFoundException(final int deviceID) {
        super("Device not found: no device with ID " + deviceID + " exists.");
    }
    public DeviceNotFoundException(final String deviceName) {
        super("Device not found: no device with name \"" + deviceName + "\" exists.");
    }
}
