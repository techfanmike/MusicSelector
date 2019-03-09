package com.example.android.musicselector;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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

        // allocate the entry list and adapter and bind
        mMusicEntryList = new ArrayList<>();
        mArrayAdapter = new MusicListEntryAdapter(this, R.layout.music_list_item_layout, mMusicEntryList);
        final ListView listViewEntries = findViewById(R.id.LIST_VIEW_SONGS);
        listViewEntries.setAdapter(mArrayAdapter);

        // create a listener, create an intent to launch to player activity
        listViewEntries.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // instantiate the entry to get the list item data
                MusicListEntry entry = (MusicListEntry) listViewEntries.getItemAtPosition(position);

                // create the intent
                Intent intent = new Intent(getApplicationContext(), PlayerActivity.class);
                intent.setAction(Intent.ACTION_SEND);

                // place the list item data in the intent for the activity to consume
                intent.putExtra("album", entry.getAlbum());
                intent.putExtra("artist", entry.getArtist());
                intent.putExtra("song", entry.getSong());

                // kick off the activity
                startActivity(intent);
            }
        });

        // add entries to the list
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
                String[] splitString = line.split(",");
                mMusicEntryList.add(new MusicListEntry(splitString[0].trim(),
                        splitString[1].trim(), splitString[2].trim(), splitString[3].trim()));
            }
        } catch (IOException e) {
            ;
        }
    }
}