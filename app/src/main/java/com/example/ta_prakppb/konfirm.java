package com.example.ta_prakppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class konfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirm);

        Button button = findViewById(R.id.button1);

        button.setOnClickListener(view -> {
            Intent kelompok = new Intent(this, homeF.class);
            startActivity(kelompok);
        });
    }
}