package com.example.myapplication;

import android.content.Intent;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = findViewById(R.id.Name_TF);
        spinner = findViewById(R.id.spinner);
        RG = findViewById(R.id.Radiogroup);
        football = findViewById(R.id.Football);
        cricket = findViewById(R.id.Cricket);
        basketball = findViewById(R.id.Basket_Ball);
        submit = findViewById(R.id.Submit);


        String [] Branches = {"CS","IT","ENTC"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,Branches);
        spinner.setAdapter(adapter);

        submit.setOnClickListener(view -> {
            String Namestring = name.getText().toString();
            String Branchstring = spinner.getSelectedItem().toString();;

            String Genderstring = "Not Selected";
            int id = RG.getCheckedRadioButtonId();
            RadioButton selecrtedRB = findViewById(id);
            Genderstring = selecrtedRB.getText().toString();

            String Sports = "";

            if(football.isChecked()){
                Sports += "Football ";
            }
            if(cricket.isChecked()){
                Sports += "cricket ";
            }
            if(basketball.isChecked()){
                Sports += "basketball ";
            }

            String Resultstring = "Name : " + Namestring + "\nBrach : " + Branchstring + "\nGender : " + Genderstring + "\nSports : " + Sports ;

            Intent i = new Intent(this,ResultActivity.class);
            i.putExtra("Data",Resultstring);
            startActivity(i);
        });

    }
}