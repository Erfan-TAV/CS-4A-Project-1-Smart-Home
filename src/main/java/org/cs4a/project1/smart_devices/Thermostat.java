package org.cs4a.project1.smart_devices;

import org.cs4a.project1.exceptions.DeviceInactiveException;
import org.cs4a.project1.exceptions.InvalidTemperatureException;
import org.cs4a.project1.interfaces.TempInterface;

class Thermostat extends Device implements TempInterface {
    private double temp;
    private double humidity;

    public static final double MIN_TEMP = 60.0;
    public static final double MAX_TEMP = 100.0;

    public Thermostat() {
        super();
        humidity = 0.0;
        temp = 0.0;
    }

    public Thermostat(boolean status, String name, double humidity, double temp) {
        super(status, name);
        //this.cooling = cooling;
        this.humidity = humidity;
        this.temp = temp;
    }

    @Override
    public void setTemp(double temp) throws InvalidTemperatureException, DeviceInactiveException {
        if (getStatus()) {
            if (temp > MAX_TEMP || temp < MIN_TEMP) {
                throw new InvalidTemperatureException(temp);
            } else {
                this.temp = temp;
            }
        } else {
            throw new DeviceInactiveException("Thermostat");
        }
    }

    @Override
    public double getTemp() throws DeviceInactiveException {
        if (getStatus()) {
            return this.temp;
        } else {
            throw new DeviceInactiveException("Thermostat");
        }
    }

    public double getHumidity() throws DeviceInactiveException {
        if (getStatus()) {
            return humidity;
        } else {
            throw new DeviceInactiveException("Thermostat");
        }
    }

}
