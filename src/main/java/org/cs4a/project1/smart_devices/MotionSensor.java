package org.cs4a.project1.smart_devices;

import org.cs4a.project1.exceptions.DeviceInactiveException;

import java.util.Random;

class MotionSensor extends Device {
    private boolean motion;

    public MotionSensor() {
        super();
        motion = false;
    }

    public MotionSensor(String name, boolean status) {
        super(status, name);
        motion = false;
    }

    public boolean checkMotion() throws DeviceInactiveException {
        if (getStatus()) {
            Random random = new Random();
            if (random.nextInt(4) == 0) {
                motion = true;
                return motion;
            } else {
                motion = false;
                return motion;
            }
        } else {
            throw new DeviceInactiveException("MotionSensor");
        }
    }

    //it feels kinda weird to set a motion sensor
    //maybe it would be cooler if I could have it so once it starts
    //it has a 1 in 100 chance every second to detect movement
    //would be cool to include date as one of the variables

    // public boolean checkMotion(){
    //     if(super().getStatus()){
    //         return motion;
    //     } else {
    //         //throw new exception
    //     }
    // }

    // public void setMotion(boolean motion){
    //     if(super().getStatus()){
    //         this.motion = motion;
    //     } else {
    //         //throw new exception
    //     }
    // }
}
