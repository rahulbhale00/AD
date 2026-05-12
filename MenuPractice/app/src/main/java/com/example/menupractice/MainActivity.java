package com.example.menupractice;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnDialog, btnPopup;
    TextView txtContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDialog = findViewById(R.id.buttonDialog);
        btnPopup = findViewById(R.id.buttonPopup);
        txtContext = findViewById(R.id.textView);

        registerForContextMenu(txtContext);

        btnDialog.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("HI");
            builder.setMessage("hello woeld");
            builder.setPositiveButton("OK",null).show();
            builder.show();
        });
        btnPopup.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(this,btnPopup);
            popupMenu.getMenu().add("popup edit ");
            popupMenu.getMenu().add("popup remove ");
        //          popupMenu.getMenuInflater().inflate(R.menu.menu_main,popupMenu.getMenu());
            popupMenu.show();
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Edit");
        menu.add("delete");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String x  = item.getTitle().toString() +" is Selected";
        Toast.makeText(this,x,Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Edit menu");
        menu.add("Remove Menu");
        //      getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String x  = item.getTitle().toString() +" is Selected";
        Toast.makeText(this,x,Toast.LENGTH_SHORT).show();
        return true;
    }
}