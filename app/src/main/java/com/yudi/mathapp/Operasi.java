package com.yudi.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Operasi extends AppCompatActivity {
    ImageButton BtnTambah, BtnKurang, BtnKali, BtnBagi, BtnopClear;
    EditText opBilangan1, opBilangan2, opHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operasi);

        BtnTambah = findViewById(R.id.BtnTambah);
        BtnKurang = findViewById(R.id.BtnKurang);
        BtnKali = findViewById(R.id.BtnKali);
        BtnBagi = findViewById(R.id.BtnBagi);
        BtnopClear = findViewById(R.id.BtnopClear);

        opBilangan1 = findViewById(R.id.opBilangan1);
        opBilangan2 = findViewById(R.id.opBilangan2);
        opHasil = findViewById(R.id.opHasil);

        BtnTambah.setOnClickListener(proses_tambah);
        BtnKurang.setOnClickListener(proses_kurang);
        BtnKali.setOnClickListener(proses_kali);
        BtnBagi.setOnClickListener(proses_bagi);
        BtnopClear.setOnClickListener(proses_opclear);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private final View.OnClickListener proses_tambah = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validateInputs()) {
                int bilangan1 = Integer.parseInt(opBilangan1.getText().toString());
                int bilangan2 = Integer.parseInt(opBilangan2.getText().toString());
                int hasil = bilangan1 + bilangan2;

                opHasil.setText(String.valueOf(hasil));
            }
        }
    };

    private final View.OnClickListener proses_kurang = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validateInputs()) {
                int bilangan1 = Integer.parseInt(opBilangan1.getText().toString());
                int bilangan2 = Integer.parseInt(opBilangan2.getText().toString());
                int hasil = bilangan1 - bilangan2;

                opHasil.setText(String.valueOf(hasil));
            }
        }
    };

    private final View.OnClickListener proses_kali = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validateInputs()) {
                int bilangan1 = Integer.parseInt(opBilangan1.getText().toString());
                int bilangan2 = Integer.parseInt(opBilangan2.getText().toString());
                int hasil = bilangan1 * bilangan2;

                opHasil.setText(String.valueOf(hasil));
            }
        }
    };

    private final View.OnClickListener proses_bagi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (validateInputs()) {
                int bilangan1 = Integer.parseInt(opBilangan1.getText().toString());
                int bilangan2 = Integer.parseInt(opBilangan2.getText().toString());
                if (bilangan2 != 0) {
                    int hasil = bilangan1 / bilangan2;
                    opHasil.setText(String.valueOf(hasil));
                } else {
                    opHasil.setText("Tidak bisa dibagi dengan nol");
                }
            }
        }
    };

    private final View.OnClickListener proses_opclear = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            opBilangan1.setText("");
            opBilangan2.setText("");
            opHasil.setText("");
        }
    };

    private boolean validateInputs() {
        if (opBilangan1.getText().toString().isEmpty() || opBilangan2.getText().toString().isEmpty()) {
            opHasil.setText("Silakan masukkan Bilangan");
            return false;
        }
        return true;
    }

    public void BtnopHome(View view) {
        Intent intent = new Intent(Operasi.this,MainActivity.class);
        startActivity(intent);
    }
}
