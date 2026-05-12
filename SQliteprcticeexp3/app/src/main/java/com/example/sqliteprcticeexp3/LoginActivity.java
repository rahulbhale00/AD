package com.example.sqliteprcticeexp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText user, pass;

    Button login;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.editUser);

        pass = findViewById(R.id.editPass);

        login = findViewById(R.id.btnLogin);

        db = new DBHelper(this);

        login.setOnClickListener(v -> {

            String username =
                    user.getText().toString();

            String password =
                    pass.getText().toString();

            boolean check =
                    db.checkUser(username, password);

            if(check){

                Toast.makeText(this,
                        "Login Success",
                        Toast.LENGTH_SHORT).show();

                startActivity(
                        new Intent(this,
                                HomeActivity.class)
                );

            } else {

                Toast.makeText(this,
                        "Invalid User",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}