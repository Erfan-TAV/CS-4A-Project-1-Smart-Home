package org.cs4a.project1.interfaces;

import org.cs4a.project1.exceptions.DeviceInactiveException;
import org.cs4a.project1.exceptions.InvalidSpeedException;
public interface SpeedInterface {

    void setSpeed(int speed)throws InvalidSpeedException,DeviceInactiveException;
    int getSpeed() throws DeviceInactiveException;

    default String getSpeedAsString() {
        try{
            return "Speed: " + getSpeed() + "%";
        } catch(DeviceInactiveException ex) {
            return "DeviceInactiveException!";
        }
    }
}
