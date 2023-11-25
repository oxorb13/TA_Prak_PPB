package com.example.ta_prakppb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nama_produk = findViewById(R.id.nama_produk);
        TextView harga_produk = findViewById(R.id.harga_produk);
        TextView rilis_produk = findViewById(R.id.rilis_produk);
        Button button = findViewById(R.id.button1);

        String nama_p = getIntent().getStringExtra("nama_produk = ");
        String harga_p = getIntent().getStringExtra("harga_produk = ");
        String rilis_p = getIntent().getStringExtra("produk_rilis = ");

        nama_produk.setText(nama_p);
        harga_produk.setText(harga_p);
        rilis_produk.setText(rilis_p);

        button.setOnClickListener(view -> {
            Intent kelompok = new Intent(this, konfirm.class);
            startActivity(kelompok);
        });
    }
}