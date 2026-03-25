package org.cs4a.project1.smart_devices;

// TODO: update interface
// public interface Device {
//     boolean setName(final String newName);
//     String getName();
//     boolean isActive();
// }
//import org.cs4a.project1.exceptions.InvalidTemperatureException;

public abstract class Device{
    private boolean status;
    private String name;

    protected Device() {
        status = false;
        name = "generic";
    }

    protected Device(boolean status, String name) {
        this.status = status;
        this.name = name;
    }

    //I dont think anything should be allowed to change if the status is off
    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}

