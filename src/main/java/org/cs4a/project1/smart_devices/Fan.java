package org.cs4a.project1.smart_devices;

import org.cs4a.project1.exceptions.DeviceInactiveException;
import org.cs4a.project1.exceptions.InvalidSpeedException;

class Fan extends Device implements SpeedInterface {
    private int speed;
    //private double temp;

    public Fan() {
        super();
        speed = 0;
    }

    @Override
    public int getSpeed() throws DeviceInactiveException {
        if (getStatus()) {
            return this.speed;
        } else {
            throw new DeviceInactiveException("Fan");
        }
    }

    // @Override
    // public void setTemp(double temp) throws InvalidTemperatureException{
    //     if(getStatus()){
    //         if(temp>100 || temp<0){
    //             throw new InvalidTemperatureException(temp);
    //         } else {

    //         }
    //     } else {
    //         throw new DeviceInactiveException("Fan");
    //     }
    // }

    @Override
    public void setSpeed(int speed) throws InvalidSpeedException, DeviceInactiveException {
        if (getStatus()) {
            if (speed > 100 || speed < 0) {
                this.speed = speed;
            } else {
                throw new InvalidSpeedException(speed);
            }
        } else {
            throw new DeviceInactiveException("Fan");
        }
    }

    public Fan(boolean status, String name, int speed) {
        super(status, name);
        this.speed = speed;
    }
}
