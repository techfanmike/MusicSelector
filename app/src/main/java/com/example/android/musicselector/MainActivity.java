package com.example.android.musicselector;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // declare our list or entries, and the adapter
    private ArrayList<MusicListEntry> mMusicEntryList = null;
    private MusicListEntryAdapter mArrayAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // allocate the entry list and adapter, and bind
        mMusicEntryList = new ArrayList<>();
        mArrayAdapter = new MusicListEntryAdapter(this, R.layout.music_list_item_layout, mMusicEntryList);
        ListView listViewEntries = findViewById(R.id.LIST_VIEW_SONGS);
        listViewEntries.setAdapter(mArrayAdapter);

        // add entries to the list, and make sure we draw updated
        populateArray();
    }

    // Create entries into the list of available music
    private void populateArray() {
        try {
            // get the handle for the file in the 'raw' folder
            Resources resource = getResources();
            InputStream is = resource.openRawResource(R.raw.music);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String line;

            // read a line until done when null returned
            while ((line = reader.readLine()) != null) {

                // split string and add entry to entry list UI object
                String[] splitString = line.split(",");
                mMusicEntryList.add(new MusicListEntry(splitString[0], splitString[1], splitString[2]));
            }
        } catch (IOException e) {
            ;
        }
    }
}