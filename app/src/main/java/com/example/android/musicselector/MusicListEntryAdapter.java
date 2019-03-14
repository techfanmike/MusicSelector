package com.example.android.musicselector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicListEntryAdapter extends ArrayAdapter<MusicListEntry> {
    public MusicListEntryAdapter(Context context, int resource, ArrayList<MusicListEntry> MusicList) {
        super(context, resource, MusicList);
    }

    // inject binding
    @BindView(R.id.artistName) TextView artist;
    @BindView(R.id.albumName) TextView album;
    @BindView(R.id.song) TextView song;
    @BindView(R.id.AlbumArt) ImageView albumArt;

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        MusicListEntry entry = getItem(position);

        // if a new list, inflate a new list item
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.music_list_item_layout, container, false);
        }

        // call the butterknife binding method
        ButterKnife.bind(this, convertView);

        // get the resource id for the album art image we will bind to the album art UI element
        int resourceID = getContext().getResources().getIdentifier(entry.getAlbumArt() , "mipmap",
                getContext().getPackageName());

        // concatenate string because setText does not like it if you concatenate in the call.
        String artistString = getContext().getString(R.string.artist_text) + "  " + entry.getArtist();
        String albumString = getContext().getString(R.string.album_text) + "  " + entry.getAlbum();
        String songString = getContext().getString(R.string.song_text) + "  " + entry.getSong();

        // set the list item UI objects
        artist.setText(artistString);
        album.setText(albumString);
        song.setText(songString);
        albumArt.setImageResource(resourceID);

        return convertView;
    }
}
