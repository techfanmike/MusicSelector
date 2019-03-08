package com.example.android.musicselector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicListEntryAdapter extends ArrayAdapter<MusicListEntry> {
    public MusicListEntryAdapter(Context context, int resource, ArrayList<MusicListEntry> MusicList) {
        super(context, resource, MusicList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        MusicListEntry entry = getItem(position);

        // if a new list, inflate a new list item
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.music_list_item_layout, container, false);
        }

        // get the resource id for the album art image we will bind to the album art UI element
        int resourceID = getContext().getResources().getIdentifier(entry.getAlbumArt() , "mipmap",
                getContext().getPackageName());

        // bind variables to UI objects to set the UI values
        TextView artist = convertView.findViewById(R.id.artistName);
        TextView album = convertView.findViewById(R.id.albumName);
        TextView song = convertView.findViewById(R.id.song);
        ImageView albumArt = convertView.findViewById(R.id.AlbumArt);

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
