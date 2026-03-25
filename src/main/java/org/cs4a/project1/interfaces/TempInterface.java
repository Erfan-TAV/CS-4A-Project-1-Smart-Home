package org.cs4a.project1.interfaces;

import org.cs4a.project1.exceptions.DeviceInactiveException;
import org.cs4a.project1.exceptions.InvalidTemperatureException;

public interface TempInterface {

    void setTemp(double temp) throws InvalidTemperatureException, DeviceInactiveException;
    double getTemp() throws DeviceInactiveException;

    default double toCelsius() {
        try{
            return (getTemp() - 32) * 5.0 / 9.0;
        } catch(DeviceInactiveException ex){
            return -1;
        }
    }

    default double toFahrenheit() {
        try{
            return (getTemp() * 9.0 / 5.0) + 32;
        } catch(DeviceInactiveException ex){
            return -1;
        }
    }

    default String getTempAsString() {
        try{
            return "Temperature: " + getTemp() + "F" +
               " (" + String.format("%.1f", toCelsius()) + "C)";
        } catch(DeviceInactiveException ex){
            return "DeviceInactiveException!";
        }
    }
}
