package com.yudi.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pangkat extends AppCompatActivity {
    ImageButton BtnProses, BtnpkClear;
    EditText pkBilangan, pkPangkat, pkHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pangkat);

        BtnProses = findViewById(R.id.BtnProses);
        BtnpkClear = findViewById(R.id.BtnpkClear);

        pkBilangan = findViewById(R.id.pkBilangan);
        pkPangkat = findViewById(R.id.pkPangkat);
        pkHasil = findViewById(R.id.pkHasil);

        BtnProses.setOnClickListener(proses_pangkat);
        BtnpkClear.setOnClickListener(proses_pkclear);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    View.OnClickListener proses_pangkat = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int bilangan = Integer.parseInt(pkBilangan.getText().toString());
            int pangkat = Integer.parseInt(pkPangkat.getText().toString());

            long hasil = (long) Math.pow(bilangan, pangkat);
            pkHasil.setText(String.valueOf(hasil));
        }
    };

    View.OnClickListener proses_pkclear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            pkBilangan.setText("");
            pkPangkat.setText("");
            pkHasil.setText("");
        }
    };

    public void BtnpkHome(View view) {
        Intent intent = new Intent(Pangkat.this,MainActivity.class);
        startActivity(intent);
    }
}