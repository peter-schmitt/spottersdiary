package com.example.peter.spottersdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.peter.spottersdiary.global.DataStorage;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private DataStorage storageObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storageObject = DataStorage.getInstance();
        Log.d(TAG, "MainActivity started");
    }

    public void spotPlane(View v) {
        Intent intent = new Intent(this, Spot_A_Plane.class);
        startActivity(intent);
    }

    public void listSpottings(View v) {
        Intent intent = new Intent(this, List_Spottings.class);
        startActivity(intent);
    }
}
