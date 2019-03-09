package com.example.android.musicselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Bundle extras = getIntent().getExtras();
        String artist = extras.getString("artist");
        String album = extras.getString("album");
        String song = extras.getString("song");

        TextView artistUI = findViewById(R.id.artistNamePlayer);
        TextView albumUI = findViewById(R.id.albumNamePlayer);
        TextView songUI = findViewById(R.id.songPlayer);
        ImageView playButtonUI = findViewById(R.id.PlayButton);

        artistUI.setText(artist);
        albumUI.setText(album);
        songUI.setText(song);
        playButtonUI.setImageResource(R.mipmap.play_btn);
    }
}
