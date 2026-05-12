package com.example.musicplayerpracticeexp8;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button Next, Prev, Play, Pause;

    ImageView imageView;

    TextView Songname, Artist;

    SeekBar seekBar;

    MediaPlayer mediaplayer;

    Handler handler = new Handler();

    int currentSong = 0;

    int[] Songs = {
            R.raw.song1,
            R.raw.song2
    };

    int[] Images = {
            R.drawable.img1,
            R.drawable.img2
    };

    String[] Songnames = {
            "Fearless Funk",
            "Superhero"
    };

    String[] Artists = {
            "DR MØB, Chris Linton",
            "Alex Hagen"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Next = findViewById(R.id.Next);
        Prev = findViewById(R.id.Prev);
        Play = findViewById(R.id.Play);
        Pause = findViewById(R.id.Pause);

        imageView = findViewById(R.id.imageView);

        Songname = findViewById(R.id.Songname);
        Artist = findViewById(R.id.Artist);

        seekBar = findViewById(R.id.seekBar);

        loadsong();

        // NEXT
        Next.setOnClickListener(view -> {

            mediaplayer.stop();

            currentSong++;

            if(currentSong >= Songs.length){
                currentSong = 0;
            }

            loadsong();

            mediaplayer.start();
        });

        // PREVIOUS
        Prev.setOnClickListener(view -> {

            mediaplayer.stop();

            currentSong--;

            if(currentSong < 0){
                currentSong = Songs.length - 1;
            }

            loadsong();

            mediaplayer.start();
        });

        // PLAY
        Play.setOnClickListener(view -> {

            mediaplayer.start();
        });

        // PAUSE
        Pause.setOnClickListener(view -> {

            mediaplayer.pause();
        });

        // SEEK BAR CHANGE
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        if(fromUser){

                            mediaplayer.seekTo(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(
                            SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(
                            SeekBar seekBar) {

                    }
                });
    }

    private void loadsong() {

        mediaplayer =
                MediaPlayer.create(this,
                        Songs[currentSong]);

        imageView.setImageResource(
                Images[currentSong]);

        Songname.setText(
                Songnames[currentSong]);

        Artist.setText(
                Artists[currentSong]);

        // SEEK BAR MAX
        seekBar.setMax(
                mediaplayer.getDuration()
        );

        // AUTO UPDATE SEEK BAR
        handler.postDelayed(updateSeekBar, 0);

        // AUTO NEXT SONG
        mediaplayer.setOnCompletionListener(mp -> {

            currentSong++;

            if(currentSong >= Songs.length){
                currentSong = 0;
            }

            loadsong();

            mediaplayer.start();
        });
    }

    Runnable updateSeekBar = new Runnable() {

        @Override
        public void run() {

            if(mediaplayer != null){

                seekBar.setProgress(
                        mediaplayer.getCurrentPosition()
                );

                handler.postDelayed(this, 500);
            }
        }
    };
}