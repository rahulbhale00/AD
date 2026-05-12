package com.example.filestorageexp9practice;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {


    Button Save,Load;
    EditText Filename,Filedata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Save = findViewById(R.id.Save);
        Load = findViewById(R.id.Load);
        Filedata = findViewById(R.id.Filedata);
        Filename = findViewById(R.id.Filename);



        Save.setOnClickListener(view -> {

            try {
                String filenamestring = Filename.getText().toString();
                String filedatastring = Filedata.getText().toString();

                FileOutputStream fos = openFileOutput(filenamestring,MODE_PRIVATE);

                fos.write(filedatastring.getBytes());

                fos.close();
                Toast.makeText(this,"File Saved.",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){

            };

        });

        Load.setOnClickListener(view -> {

            try {
                String filenamestring = Filename.getText().toString();
                String filedatastring = "";

                java.io.FileInputStream fis = openFileInput(filenamestring);

                int character;  //ascci value    use char(character) to get charater datatype

                while ((character = fis.read()) != -1) {
                    filedatastring += Character.toString((char)character);
                }

                Filedata.setText(filedatastring);

                fis.close();
                Toast.makeText(this,"File Loaded.",Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){

            };

        });

    }
}