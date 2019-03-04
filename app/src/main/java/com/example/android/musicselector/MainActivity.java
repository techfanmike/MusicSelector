package com.example.android.musicselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
        mMusicEntryList.add(new MusicListEntry("Rush", "Exit...Stage Left", "YYZ"));
        mMusicEntryList.add(new MusicListEntry("Rush", "Exit...Stage Left", "Red Barchetta"));
        mMusicEntryList.add(new MusicListEntry("Rush", "Exit...Stage Left", "Jacob's Ladder"));
        mMusicEntryList.add(new MusicListEntry("Rush", "Exit...Stage Left", "The Trees"));
        mMusicEntryList.add(new MusicListEntry("Rush", "Test for Echo", "Test for Echo"));
        mMusicEntryList.add(new MusicListEntry("Rush", "Test for Echo", "Driven"));
        mMusicEntryList.add(new MusicListEntry("Rush", "Test for Echo", "Half the World"));
        mMusicEntryList.add(new MusicListEntry("Rush", "Test for Echo", "Resist"));
        mMusicEntryList.add(new MusicListEntry("U2", "Joshua Tree", "Where the Streets Have No Name"));
        mMusicEntryList.add(new MusicListEntry("U2", "Joshua Tree", "I Still Haven't Found What I'm Looking For"));
        mMusicEntryList.add(new MusicListEntry("U2", "Joshua Tree", "With or Without You"));
        mMusicEntryList.add(new MusicListEntry("U2", "Joshua Tree", "In God's Country"));
        mMusicEntryList.add(new MusicListEntry("U2", "Joshua Tree", "Exit"));
        mMusicEntryList.add(new MusicListEntry("U2", "Achtung Baby", "Zoo Station"));
        mMusicEntryList.add(new MusicListEntry("U2", "Achtung Baby", "Even Better Than the Real Thing"));
        mMusicEntryList.add(new MusicListEntry("U2", "Achtung Baby", "One"));
        mMusicEntryList.add(new MusicListEntry("U2", "Achtung Baby", "Until the End of the World"));
    }
}