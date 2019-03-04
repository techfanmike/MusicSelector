package com.example.android.musicselector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        // get the text fields from the layout file
        TextView artist = convertView.findViewById(R.id.artistName);
        TextView album = convertView.findViewById(R.id.albumName);
        TextView song = convertView.findViewById(R.id.song);

        // set the text fields for the list item
        artist.setText(entry.getArtist());
        album.setText(entry.getAlbum());
        song.setText(entry.getSong());

        return convertView;
    }
}
