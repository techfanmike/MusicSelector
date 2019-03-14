package com.example.android.musicselector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerActivity extends AppCompatActivity {

    // inject bindings
    @BindView(R.id.artistNamePlayer) TextView artistUI;
    @BindView(R.id.songPlayer) TextView songUI;
    @BindView(R.id.PlayButton) ImageView playButtonUI;
    @BindView(R.id.BackgroundView) ImageView backGroundAlbum;
    @BindView(R.id.albumNamePlayer) TextView albumUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // make bindings
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        String artist = extras.getString("artist");
        String album = extras.getString("album");
        String song = extras.getString("song");
        String background = extras.getString("background");

        // get the resource id for the album art image we will bind to the album art UI element
        int resourceID = getResources().getIdentifier(background , "mipmap",
                getPackageName());

        // set the text in the view
        artistUI.setText(artist);
        albumUI.setText(album);
        songUI.setText(song);
        playButtonUI.setImageResource(R.mipmap.play_btn);

        // set a background image and alpha down
        backGroundAlbum.setImageResource(resourceID);
        backGroundAlbum.setImageAlpha(64);
    }
}
