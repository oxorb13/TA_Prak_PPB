package com.example.ta_prakppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        TextView nama_film = findViewById(R.id.nama_film);
        TextView rilis_film = findViewById(R.id.rilis_film);
        TextView tipe_film = findViewById(R.id.tipe_film);
        TextView timeline_film = findViewById(R.id.timeline_film);
        Button button = findViewById(R.id.button1);

        String nama_f = getIntent().getStringExtra("Nama Film = ");
        String rilis_f = getIntent().getStringExtra("Rilis Film = ");
        String tipe_f = getIntent().getStringExtra("Tipe Film = ");
        String timeline_f = getIntent().getStringExtra("Timeline Film = ");

        nama_film.setText(nama_f);
        rilis_film.setText(rilis_f);
        tipe_film.setText(tipe_f);
        timeline_film.setText(timeline_f);

        button.setOnClickListener(view -> {
            Intent kelompok = new Intent(this, konfirm.class);
            startActivity(kelompok);
        });
    }
}