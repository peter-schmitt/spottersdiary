package com.example.peter.spottersdiary;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.peter.spottersdiary.aircraft.*;
import com.example.peter.spottersdiary.airport.*;
import com.example.peter.spottersdiary.global.DataStorage;
import com.example.peter.spottersdiary.sighting.Sighting;

import java.util.Date;

public class Spot_A_Plane extends AppCompatActivity {
    private static final String TAG = "Spot_A_Plane_Activity";
    private DataStorage the_data;
    Calendar theDate = Calendar.getInstance();
    DatePickerDialog datePickerDialog;
            //new DatePickerDialog(this, Spot_A_Plane.this, theDate.get(Calendar.YEAR), theDate.get(Calendar.MONTH), theDate.get(Calendar.DAY_OF_MONTH));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot__a__plane);
        the_data = DataStorage.getInstance();
    }

    public void showDatePickerDialog(View v) {
        datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                theDate.set(Calendar.YEAR, i);
                theDate.set(Calendar.MONTH, i1);
                theDate.set(Calendar.DAY_OF_MONTH, i2);

                Log.d(TAG, "onDateSet() returned for i: " + i);
                Log.d(TAG, "onDateSet() returned for i1: " + i1);
                Log.d(TAG, "onDateSet() returned for i2: " + i2);
                Log.d(TAG, "onDateSet() returned for Calendar.YEAR: " + theDate.get(Calendar.YEAR));
                Log.d(TAG, "onDateSet() returned for Calendar.MONTH: " + theDate.get(Calendar.MONTH));
                Log.d(TAG, "onDateSet() returned for Calendar.DAY_OF_MONTH: " + theDate.get(Calendar.DAY_OF_MONTH));
            }
        });
        Log.d(TAG, "started DatePicker");
        datePickerDialog.show();
    }

    public void onClickCancel(View v) {
        NavUtils.navigateUpFromSameTask(this);
    }

    public void onClickSave(View v) {
        // prepare aircraft information
        EditText text_plane_registration = (EditText)findViewById(R.id.text_plane_registration);
        EditText text_plane_manufacturer = (EditText)findViewById(R.id.autoCompleteTextView_aircraft_manufacturer);
        EditText text_plane_type = (EditText)findViewById(R.id.autoCompleteTextView_aircraft_type);
        EditText text_plane_ICAO_code = (EditText)findViewById(R.id.autoCompleteTextView_aircraft_ICAO_code);
        EditText text_plane_airline = (EditText)findViewById(R.id.autoCompleteTextView_aircraft_airline);

        Aircraft the_aircraft = new Aircraft(text_plane_type.getText().toString(), text_plane_manufacturer.getText().toString(), text_plane_ICAO_code.getText().toString(), text_plane_registration.getText().toString(), text_plane_airline.getText().toString());

        // prepare airport information
        EditText text_airport_ICAO_code = (EditText)findViewById(R.id.autoCompleteTextView_airport_ICAO_code);
        EditText text_airport_name = (EditText)findViewById(R.id.autoCompleteTextView_airport_name);
        EditText text_airport_city = (EditText)findViewById(R.id.autoCompleteTextView_airport_city);
        EditText text_airport_land = (EditText)findViewById(R.id.autoCompleteTextView_airport_land);

        Airport the_airport = new Airport(text_airport_ICAO_code.getText().toString(), text_airport_name.getText().toString(), text_airport_city.getText().toString(), text_airport_land.getText().toString());

        //create the sighting
        the_data.addSighting(new Sighting(the_aircraft, theDate, the_airport));

        NavUtils.navigateUpFromSameTask(this);
    }
}
