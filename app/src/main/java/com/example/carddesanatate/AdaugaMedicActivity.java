package com.example.carddesanatate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.jvm.internal.SpreadBuilder;

public class AdaugaMedicActivity extends AppCompatActivity {

    private EditText etNumeMedic, etPrenumeMedic, etSpitalDeProvenienta;
    private Button bttnAdaugaMedic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_medic);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String numeMedic = etNumeMedic.getText().toString();
        String prenumeMedic = etPrenumeMedic.getText().toString();
        String spitalDeProvenienta = etSpitalDeProvenienta.getText().toString();

        etNumeMedic = findViewById(R.id.etNumeMedic);
        etPrenumeMedic = findViewById(R.id.etPrenumeMedic);
        etSpitalDeProvenienta = findViewById(R.id.etSpitalDeProvenienta);

        Medic medic = new Medic(numeMedic, prenumeMedic, spitalDeProvenienta, "CARDIOLOGIE");

        bttnAdaugaMedic.setOnClickListener(view-> {
            Toast.makeText(this, medic.toString(), Toast.LENGTH_SHORT).show();
        }
        );
    }
}