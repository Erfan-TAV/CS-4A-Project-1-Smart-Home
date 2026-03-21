package org.cs4a.project1;

public interface TempInterface {

    void setTemp(double temp);
    double getTemp();

    default double toCelsius() {
        return (getTemp() - 32) * 5.0 / 9.0;
    }

    default double toFahrenheit() {
        return (getTemp() * 9.0 / 5.0) + 32;
    }

    default String getTempAsString() {
        return "Temperature: " + getTemp() + "F" +
               " (" + String.format("%.1f", toCelsius()) + "C)";
    }
}
