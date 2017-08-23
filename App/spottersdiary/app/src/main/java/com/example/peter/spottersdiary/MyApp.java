package com.example.peter.spottersdiary;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.peter.spottersdiary.global.DataStorage;
import com.example.peter.spottersdiary.sighting.Sighting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Peter on 23.08.2017.
 */

public class MyApp extends Application {

    private DataStorage storageObject;
    // Constant with a file name
    public static String fileName = "Sightings.ser";
    private static String TAG = "MyApp";

    public MyApp() {
        // this method fires only once per application start.
        // getApplicationContext returns null here

        Log.i("main", "Constructor fired");

    }

    @Override
    public void onCreate() {
        super.onCreate();

        // this method fires once as well as constructor
        // but also application has context here

        Log.i("main", "onCreate fired");

        storageObject = DataStorage.getInstance();

        readFromFile(this);
    }

    // Serializes an object and saves it to a file
    public static void saveToFile(Context context, ArrayList<Sighting> object) {
        try {
            Log.d(TAG, "save started");
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Creates an object by reading it from a file
    public static void readFromFile(Context context) {
        DataStorage the_data = DataStorage.getInstance();
        try {
            Log.d(TAG, "read started");
            FileInputStream fileInputStream = context.openFileInput(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            the_data.initializeStorage((ArrayList<Sighting>) objectInputStream.readObject());
            objectInputStream.close();
            fileInputStream.close();
        }
        catch (IOException e) {
            Log.d(TAG, "IOException in file read: " + e.toString());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

