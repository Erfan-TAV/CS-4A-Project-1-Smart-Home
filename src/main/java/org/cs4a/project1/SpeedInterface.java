package org.cs4a.project1;

public interface SpeedInterface {

    void setSpeed(double speed);
    double getSpeed();

    default String getSpeedAsString() {
        return "Speed: " + getSpeed() + "%";
    }
}
