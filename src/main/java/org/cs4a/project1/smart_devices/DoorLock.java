package org.cs4a.project1.smart_devices;

import org.cs4a.project1.exceptions.DeviceInactiveException;

class DoorLock extends Device {
    private boolean open;

    public DoorLock() {
        super();
        open = false;
    }

    public DoorLock(String name, boolean status, boolean open) {
        super(status, name);
        this.open = open;
    }

    public void setLockOpen(boolean open) throws DeviceInactiveException {
        if (getStatus()) {
            this.open = open;
        } else {
            throw new DeviceInactiveException("DoorLock");
        }
    }

    public boolean checkLock() throws DeviceInactiveException {
        if (getStatus()) {
            return this.open;
        } else {
            throw new DeviceInactiveException("DoorLock");
        }
    }
}
