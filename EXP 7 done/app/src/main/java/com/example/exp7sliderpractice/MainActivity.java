package com.example.exp7sliderpractice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button back;
    Button next;

    int [] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
    };

    int currentimg = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        back = findViewById(R.id.back);
        next = findViewById(R.id.next);
        imageView = findViewById(R.id.imageView);


        imageView.setImageResource(images[currentimg]);

        next.setOnClickListener(view -> {
            currentimg++;

            if(currentimg >= images.length ){
                currentimg = 0;
            }

            imageView.setImageResource(images[currentimg]);
        });

        back.setOnClickListener(view -> {
            currentimg--;

            if(currentimg < 0 ){
                currentimg = images.length - 1 ;
            }

            imageView.setImageResource(images[currentimg]);
        });

    }
}