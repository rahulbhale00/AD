package com.example.musicplayerpracticeexp8;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button Next , Prev , Play , Pause ;
    ImageView imageView;
    TextView Songname,Artist;

    MediaPlayer mediaplayer;

    int currentSong = 0;

    int [] Songs = {
            R.raw.song1,
            R.raw.song2
    };

    int [] Images = {
            R.drawable.img1,
            R.drawable.img2
    };
    String [] Songnames = {
            "Fearless Funk",
            "Superhero"
    };

    String [] Artists = {
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

        loadsong();

        Next.setOnClickListener(view -> {
            mediaplayer.stop();
            currentSong++;
            if(currentSong >= Songs.length){
                currentSong = 0;
            }
            loadsong();
            mediaplayer.start();
        });


        Prev.setOnClickListener(view -> {
            mediaplayer.stop();
            currentSong--;
            if(currentSong < 0){
                currentSong = Songs.length - 1;
            }
            loadsong();
            mediaplayer.start();
        });

        Play.setOnClickListener(view -> {
            mediaplayer.start();
        });

        Pause.setOnClickListener(view -> {
            mediaplayer.stop();
        });

    }

    private void loadsong() {

        mediaplayer = MediaPlayer.create(this,Songs[currentSong]);
        imageView.setImageResource(Images[currentSong]);
        Songname.setText(Songnames[currentSong]);
        Artist.setText(Artists[currentSong]);

    }


}