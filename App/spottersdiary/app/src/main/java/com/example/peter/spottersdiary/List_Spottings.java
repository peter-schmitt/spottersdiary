package com.example.peter.spottersdiary;

import android.preference.PreferenceFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.peter.spottersdiary.global.DataStorage;
import com.example.peter.spottersdiary.sighting.Sighting;

import java.util.ArrayList;

public class List_Spottings extends AppCompatActivity {

    DataStorage theData;
    private ListView listView_list_spottings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_spottings);

        theData = DataStorage.getInstance();

        listView_list_spottings = (ListView) findViewById(R.id.listView_list_spottings);
        ArrayList<String> listItems = theData.toStringArray();

        // 4
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        listView_list_spottings.setAdapter(adapter);
    }
}
