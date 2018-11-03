package com.example.demo;

public class DeviceData {

    private String o2;
    private String co2;
    private String voc;
    private String temperature;
    private String humidity;
    private String latitude;
    private String longitude;
    private String elevation;
    private String deviceID;

    public String getO2() {
        return o2;
    }

    public void setO2(String o2) {
        this.o2 = o2;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getVoc() {
        return voc;
    }

    public void setVoc(String voc) {
        this.voc = voc;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    @Override
    public String toString() {
        
        return
                ("o2: ") + o2 + System.lineSeparator() + ("co2: ") + co2 + System.lineSeparator() +
                ("voc: ") +voc + System.lineSeparator() + ("temperature: ") + temperature +
                System.lineSeparator() + ("humidity: ") + humidity + System.lineSeparator() +
                        ("latitude: ") + latitude + System.lineSeparator() +
                        ("longitude: ") +longitude + System.lineSeparator() +
                        ("elevation: ") +elevation + System.lineSeparator() +
                        ("deviceID: ") +deviceID + System.lineSeparator();
    }
}

