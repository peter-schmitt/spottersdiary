package com.example.peter.spottersdiary.sighting;

import android.icu.util.Calendar;

import com.example.peter.spottersdiary.aircraft.*;
import com.example.peter.spottersdiary.airport.Airport;

import java.util.Date;


/**
 * Created by peter on 20.08.2017.
 */

public class Sighting {
    private Aircraft the_aircraft;
    private Calendar the_date;
    private Airport the_airport;

    public Sighting(Aircraft the_aircraft, Calendar the_date, Airport the_airport) {
        this.the_aircraft = the_aircraft;
        this.the_date = the_date;
        this.the_airport = the_airport;
    }
}
