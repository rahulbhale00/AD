package com.example.sqliteprcticeexp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;

    Button signup, loginPage;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.editUser);

        pass = findViewById(R.id.editPass);

        signup = findViewById(R.id.btnSignup);

        loginPage = findViewById(R.id.btnLoginPage);

        db = new DBHelper(this);

        signup.setOnClickListener(v -> {

            String username =
                    user.getText().toString();

            String password =
                    pass.getText().toString();

            db.insertData(username, password);

            Toast.makeText(this,
                    "Signup Successful",
                    Toast.LENGTH_SHORT).show();
        });

        loginPage.setOnClickListener(v -> {

            startActivity(
                    new Intent(this,
                            LoginActivity.class)
            );
        });
    }
}