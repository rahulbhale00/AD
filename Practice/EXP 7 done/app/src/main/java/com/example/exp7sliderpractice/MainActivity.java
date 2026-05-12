

package com.example.exp7sliderpractice;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;

    Button back, next;

    int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        back = findViewById(R.id.back);

        next = findViewById(R.id.next);

        ImageAdapter adapter =
                new ImageAdapter(images);

        viewPager.setAdapter(adapter);

        next.setOnClickListener(v -> {

            int current =
                    viewPager.getCurrentItem();

            if(current < images.length - 1){

                viewPager.setCurrentItem(current + 1);
            }
        });

        back.setOnClickListener(v -> {

            int current =
                    viewPager.getCurrentItem();

            if(current > 0){

                viewPager.setCurrentItem(current - 1);
            }
        });
    }
}