package com.example.demo;

public class DeviceData {

    private double o2;
    private double co2;
    private double voc;
    private double temperature;
    private double humidity;
    private double latitude;
    private double longitude;
    private double elevation;
    private double deviceID;

    public double getO2() {
        return o2;
    }

    public void setO2(double o2) {
        this.o2 = o2;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public double getVoc() {
        return voc;
    }

    public void setVoc(double voc) {
        this.voc = voc;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(double deviceID) {
        this.deviceID = deviceID;
    }

    @Override
    public String toString() {

        return                
                String.valueOf(o2) + System.lineSeparator()
                        + String.valueOf(co2) + System.lineSeparator()
                        + String.valueOf(voc) + System.lineSeparator()
                        + String.valueOf(temperature) + System.lineSeparator()
                        + String.valueOf(humidity) + System.lineSeparator()
                        + String.valueOf(latitude) + System.lineSeparator()
                        + String.valueOf(longitude) + System.lineSeparator()
                        + String.valueOf(elevation) + System.lineSeparator()
                        + String.valueOf(deviceID) + System.lineSeparator();
    }
}

