package org.cs4a.project1;

public class InvalidTemperatureException extends Exception {

    private final double invalidTemp;

    public static final double MIN_TEMP = 60.0;
    public static final double MAX_TEMP = 100.0;

    public InvalidTemperatureException(double temp) {
        super(buildMessage(temp));
        this.invalidTemp = temp;
    }

    public double getInvalidTemp() {
        return invalidTemp;
    }

    private static String buildMessage(double temp) {
        if (temp > MAX_TEMP) {
            return "Invalid temperature: " + temp + "F. Temperature cannot exceed " + MAX_TEMP + "F.";
        } else {
            return "Invalid temperature: " + temp + "F. Temperature cannot be below " + MIN_TEMP + "F.";
        }
    }
}
