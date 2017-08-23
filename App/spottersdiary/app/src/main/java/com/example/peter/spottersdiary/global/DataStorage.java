package com.example.peter.spottersdiary.global;

import com.example.peter.spottersdiary.sighting.Sighting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 23.08.2017.
 */

public class DataStorage  {

    // DataStorage must be a semaphore.
    private static DataStorage instance;
    private DataStorage() {
        this.the_sightings = new ArrayList<Sighting>();
    }

    public static DataStorage getInstance() {
        if (DataStorage.instance == null) {
            DataStorage.instance = new DataStorage();
        }

        return DataStorage.instance;
    }

    // actual payload:
    private List<Sighting> the_sightings;

    public void addSighting(Sighting the_sighting){
        this.the_sightings.add(the_sighting);
    }
}
