package com.example.peter.spottersdiary.airport;

/**
 * Created by Peter on 23.08.2017.
 */

public class Airport {
    private String airport_icao;
    private String name;
    private String city;
    private String land;

    public Airport(String airport_icao, String name, String city, String land) {
        this.airport_icao = airport_icao;
        this.name = name;
        this.city = city;
        this.land = land;
    }
}
