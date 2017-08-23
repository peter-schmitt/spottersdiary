package com.example.peter.spottersdiary.aircraft;

/**
 * Created by peter on 20.08.2017.
 */

public class AircraftType {
    private String type;
    private String manufacturer;
    private String ICAO_code;

    public AircraftType(String type, String manufacturer, String ICAO_code) {
        this.type = type;
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
