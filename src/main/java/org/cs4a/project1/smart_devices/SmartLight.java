package org.cs4a.project1.smart_devices;

import org.cs4a.project1.exceptions.DeviceInactiveException;

class SmartLight extends Device {
    private boolean light;
    private double intensity;
    private int color;

    public SmartLight() {
        super();
        light = false;
        intensity = 0.0;
        color = 0;
    }

    public SmartLight(boolean status, String name, boolean light, double intensity, int color) {
        super(status, name);
        this.light = light;
        this.intensity = intensity;
        this.color = color;

    }

    public void setOnOff(boolean light) throws DeviceInactiveException {
        if (getStatus()) {
            this.light = light;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public boolean getLight() throws DeviceInactiveException {
        if (getStatus()) {
            return this.light;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public void setIntensity(double intensity) throws DeviceInactiveException {
        if (getStatus()) {
            this.intensity = intensity;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public double getIntensity() throws DeviceInactiveException {
        if (getStatus()) {
            return intensity;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public void setColor(int color) throws DeviceInactiveException {
        if (getStatus()) {
            this.color = color;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public double getColor() throws DeviceInactiveException {
        if (getStatus()) {
            return this.color;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }
}
