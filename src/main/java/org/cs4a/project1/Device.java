package org.cs4a.project1;

import java.util.Random;
import org.cs4a.project1.exceptions.DeviceInactiveException;
import org.cs4a.project1.exceptions.InvalidSpeedException;
import org.cs4a.project1.exceptions.InvalidTemperatureException;
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

class Thermostat extends Device implements TempInterface{
    private double temp;
    private double humidity;

    public static final double MIN_TEMP = 60.0;
    public static final double MAX_TEMP = 100.0;

    public Thermostat(){
        super();
        humidity = 0.0;
        temp = 0.0;
    }

    public Thermostat(boolean status, String name, double humidity, double temp){
        super(status, name);
        //this.cooling = cooling;
        this.humidity = humidity;
        this.temp = temp;
    }

    @Override
    public void setTemp(double temp) throws InvalidTemperatureException, DeviceInactiveException{
        if(getStatus()){
            if(temp > MAX_TEMP || temp < MIN_TEMP){
                throw new InvalidTemperatureException(temp);
            } else {
                this.temp = temp;
            }
        } else {
            throw new DeviceInactiveException("Thermostat");
        }
    }
    
    @Override
    public double getTemp() throws DeviceInactiveException{
        if(getStatus()){
            return this.temp;
        } else {
            throw new DeviceInactiveException("Thermostat");
        }
    }

    public double getHumidity() throws DeviceInactiveException{
        if(getStatus()){
            return humidity;
        } else {
            throw new DeviceInactiveException("Thermostat");
        }
    }
  
}

class DoorLock extends Device{
    private boolean open;
    public DoorLock(){
        super();
        open = false;
    }
    public DoorLock(String name, boolean status,boolean open){
        super(status,name);
        this.open = open;
    }

    public void setLockOpen(boolean open) throws DeviceInactiveException{
        if(getStatus()){
            this.open = open;
        } else {
            throw new DeviceInactiveException("DoorLock");
        }
    }

    public boolean checkLock() throws DeviceInactiveException{
        if(getStatus()){
            return this.open;
        } else {
            throw new DeviceInactiveException("DoorLock");
        }
    }
}

class MotionSensor extends Device{
    private boolean motion;
    public MotionSensor(){
        super();
        motion = false;
    }
    public MotionSensor(String name, boolean status){
        super(status,name);
        motion = false;
    }

    public boolean checkMotion() throws DeviceInactiveException{
        if(getStatus()){
            Random random = new Random();
            if (random.nextInt(4) == 0){
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

class Fan extends Device implements SpeedInterface{
    private int speed;
    //private double temp; 

    public Fan(){
        super();
        speed = 0;
    }

    @Override
    public int getSpeed() throws DeviceInactiveException{
        if(getStatus()){
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
    public void setSpeed(int speed) throws InvalidSpeedException, DeviceInactiveException{
        if(getStatus()){
            if(speed>100 || speed<0){
                this.speed = speed;
            } else {
                throw new InvalidSpeedException(speed);
            }
        } else {
            throw new DeviceInactiveException("Fan");
        }
    }

    public Fan(boolean status, String name,int speed){
        super(status, name);
        this.speed = speed;
    }
}

class SmartLight extends Device{
    private boolean light;
    private double intensity;
    private int color;

    public SmartLight(){
        super();
        light = false;
        intensity = 0.0;
        color = 0;
    }

    public SmartLight(boolean status, String name, boolean light, double intensity, int color){
        super(status, name);
        this.light = light;
        this.intensity = intensity;
        this.color = color;

    }

    public void setOnOff(boolean light) throws DeviceInactiveException{
        if(getStatus()){
            this.light = light;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public boolean getLight() throws DeviceInactiveException{
        if(getStatus()){
            return this.light;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public void setIntensity(double intensity) throws DeviceInactiveException{
        if(getStatus()){
            this.intensity = intensity;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public double getIntensity() throws DeviceInactiveException{
        if(getStatus()){
            return intensity;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public void setColor(int color) throws DeviceInactiveException{
        if(getStatus()){
            this.color = color;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }

    public double getColor() throws DeviceInactiveException{
        if(getStatus()){
            return this.color;
        } else {
            throw new DeviceInactiveException("SmartLight");
        }
    }    
}