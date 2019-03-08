package com.example.android.musicselector;

import android.media.Image;
import android.widget.ImageView;

// A data class to contain the information for each music list item
public class MusicListEntry {
    private String mArtist = "";
    private String mAlbum = "";
    private String mSong = "";
    private String mAlbumArt = "";

    // assign the member variables in the constructor
    public MusicListEntry(String Artist, String Album, String Song, String AlbumArt) {
        mArtist = Artist;
        mAlbum = Album;
        mSong = Song;
        mAlbumArt = AlbumArt;
    }

    // define the accessor for artist
    public String getArtist() {
        return mArtist;
    }

    // define the accessor for album
    public String getAlbum() {
        return mAlbum;
    }

    // define the accessor for song
    public String getSong() {
        return mSong;
    }

    // define the accessor for the album art
    public String getAlbumArt() { return mAlbumArt; }
}
