package org.cs4a.project1.exceptions;

public class InvalidSpeedException extends Exception {

    private final int invalidSpeed;

    public InvalidSpeedException(int speed) {
        super(buildMessage(speed));
        this.invalidSpeed = speed;
    }

    public int getInvalidSpeed() {
        return invalidSpeed;
    }

    private static String buildMessage(int speed) {
        if (speed < 0) {
            return "Invalid speed: " + speed + ". Speed cannot be negative.";
        } else {
            return "Invalid speed: " + speed + ". Speed cannot exceed 100%.";
        }
    }
}
 