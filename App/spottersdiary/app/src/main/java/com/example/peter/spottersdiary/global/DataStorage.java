package com.example.peter.spottersdiary.global;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.example.peter.spottersdiary.R;
import com.example.peter.spottersdiary.sighting.Sighting;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.Serializable;

import static java.util.Locale.getDefault;


/**
 * Created by Peter on 23.08.2017.
 */

public class DataStorage implements Serializable{

    // DataStorage must be a semaphore.
    private static DataStorage instance;
    private static final String TAG = "DataStorage";

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
    private ArrayList<Sighting> the_sightings;

    public ArrayList<Sighting> getThe_sightings() {
        return the_sightings;
    }

    public void initializeStorage(ArrayList<Sighting> sightings) {
        this.the_sightings = sightings;
    }

    public ArrayList<Sighting> getSightings(){
        return this.the_sightings;
    }

    public void addSighting(Sighting the_sighting) {
        this.the_sightings.add(the_sighting);
    }

    public ArrayList<String> toStringArray() {
        Log.d(TAG, "toStringArray started");
        ArrayList<String> theArray = new ArrayList<String>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YYYY" , Locale.getDefault());
        for (Sighting sighting : this.the_sightings) {
            theArray.add(sighting.getThe_aircraft().getRegister() + " " + sighting.getThe_aircraft().getType().getType() + " " + format.format(sighting.getThe_date().getTime()));
        }
        return theArray;
    }

}
