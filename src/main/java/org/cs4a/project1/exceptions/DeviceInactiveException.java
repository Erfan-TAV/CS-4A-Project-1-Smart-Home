package org.cs4a.project1.exceptions;

public class DeviceInactiveException extends Exception {

    private final String deviceName;

    public DeviceInactiveException(String deviceName) {
        super("Cannot perform operation on \"" + deviceName + "\": device is not active. Turn the device on first.");
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }
}
