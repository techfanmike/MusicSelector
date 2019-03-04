package com.example.android.musicselector;

// A data class to contain the information for each music list item
public class MusicListEntry {
    private String mArtist = "";
    private String mAlbum = "";
    private String mSong = "";

    // assign the member variables in the constructor
    public MusicListEntry(String Artist, String Album, String Song) {
        mArtist = Artist;
        mAlbum = Album;
        mSong = Song;
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
}
