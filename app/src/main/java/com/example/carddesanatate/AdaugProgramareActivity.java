package com.example.carddesanatate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdaugProgramareActivity extends AppCompatActivity {
    private EditText etCNPPacient, etDataProgramarii, etOraProgramarii, etDenumireSpital, etNumeMedic;
    private Button bttnAdaugareProgramare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaug_programare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etCNPPacient = findViewById(R.id.etCNPPacient);
        etDataProgramarii = findViewById(R.id.etDataProgramarii);
        etOraProgramarii = findViewById(R.id.etOraProgramarii);
        etDenumireSpital = findViewById(R.id.etDenumireaSpital);
        etNumeMedic = findViewById(R.id.etNumeMedic);
        bttnAdaugareProgramare = findViewById(R.id.bttnAdaugareProgramare);

        bttnAdaugareProgramare.setOnClickListener(view -> {
            String cnpPacient = etCNPPacient.getText().toString();
            String data = etDataProgramarii.getText().toString();
            String oraProgramarii = etOraProgramarii.getText().toString();
            String denumireSpital = etDenumireSpital.getText().toString();
            String numeMedic = etNumeMedic.getText().toString();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataProgramarii = null;
            try {
                dataProgramarii = sdf.parse(data);
            } catch (ParseException e) {
                Toast.makeText(this, "Data introdusă nu este validă", Toast.LENGTH_SHORT).show();
                return;
            }

            Programare programare = new Programare(cnpPacient, dataProgramarii, oraProgramarii, denumireSpital, numeMedic);
            Intent intent = new Intent();
            intent.putExtra("programareFromIntent", programare);
            setResult(RESULT_OK, intent);
            finish();
        });



    }
}