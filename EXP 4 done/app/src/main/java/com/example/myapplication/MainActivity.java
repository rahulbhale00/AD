package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Spinner spinner;
    RadioGroup RG;
    CheckBox football,cricket,basketball;
    Button submit;
    TextView resulttf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        name = findViewById(R.id.Name_TF);
        spinner = findViewById(R.id.spinner);
        RG = findViewById(R.id.Radiogroup);
        football = findViewById(R.id.Football);
        cricket = findViewById(R.id.Cricket);
        basketball = findViewById(R.id.Basket_Ball);
        submit = findViewById(R.id.Submit);
        resulttf = findViewById(R.id.Result);

        String[] branch = {"Cs","IT","ENTC"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                branch
        );
        spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleClick();
            }

            private void HandleClick() {

                //get name
                String username = name.getText().toString();

                //get spinner
                String branch = spinner.getSelectedItem().toString();

                //gender
                String gender = "not selected";
                int id = RG.getCheckedRadioButtonId();
                RadioButton seletcedbutton = findViewById(id);
                gender = seletcedbutton.getText().toString();

                //sport

                String sports = "";

                if (football.isChecked()) {
                    sports += "football ";
                }

                if (basketball.isChecked()) {
                    sports += "basketball ";
                }
                if (cricket.isChecked()) {
                    sports += "cricket ";
                }


                String outpout = "Name : " + username + "\nBranch : " + branch + "\nGender : " + gender + "\nSports : " + sports;
                resulttf.setText(outpout);
            }
        });

    }
}