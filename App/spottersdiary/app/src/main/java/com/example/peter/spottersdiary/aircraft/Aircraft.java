package com.example.peter.spottersdiary.aircraft;

import java.io.Serializable;

/**
 * Created by peter on 20.08.2017.
 */

public class Aircraft implements Serializable{
    private AircraftType type;
    private String register;
    private String airline;

    public Aircraft(AircraftType type, String register, String airline) {
        this.type = type;
        this.register = register;
        this.airline = airline;
    }

    public Aircraft(String type, String manufacturer, String ICAO_code, String register,  String airline) {
        this.type = new AircraftType(type, manufacturer, ICAO_code);

        this.register = register;
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public AircraftType getType() {
        return type;
    }

    public void setType(AircraftType type) {
        this.type = type;
    }
}
