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

public class AdaugaAnalizeActivity extends AppCompatActivity {

    private EditText tvNume, tvSpital, tvNumePacient, tvPrenumePacient, tvCNP, tvMedic, tvSectie;
    private boolean isEditing = false;
    private AnalizeDB db;
    private Analize analizaExistenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_analize);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvNume = findViewById(R.id.tvNume);
        tvSpital = findViewById(R.id.tvSpital);
        tvNumePacient = findViewById(R.id.tvNumePacient);
        tvPrenumePacient = findViewById(R.id.tvPrenumePacient);
        tvCNP = findViewById(R.id.tvCNP);
        tvMedic = findViewById(R.id.tvMedic);
        tvSectie = findViewById(R.id.tvSectie);
        Button bttnAdaugareAnalize = findViewById(R.id.bttnAdaugareAnalize);

        db = AnalizeDB.getInstance(getApplicationContext());

        Intent editIntent = getIntent();
        if (editIntent.hasExtra("edit")) {
            isEditing = true;
            analizaExistenta = (Analize) editIntent.getSerializableExtra("edit");
            if (analizaExistenta != null) {
                tvNume.setText(analizaExistenta.getNumeAnalize());
                tvCNP.setText(analizaExistenta.getCNP());
                tvMedic.setText(analizaExistenta.getNumeMedic());
                tvSpital.setText(analizaExistenta.getDenumireSpital());
                tvSectie.setText(analizaExistenta.getSectieSptial());
            }
        }

        bttnAdaugareAnalize.setOnClickListener(view -> {
            Analize newAnaliza = new Analize(
                    1000,
                    tvNume.getText().toString(),
                    tvSpital.getText().toString(),
                    tvNumePacient.getText().toString(),
                    tvPrenumePacient.getText().toString(),
                    tvCNP.getText().toString(),
                    tvMedic.getText().toString(),
                    tvSectie.getText().toString()
            );

            if (isEditing && analizaExistenta != null) {
                newAnaliza.setIdAnalize(analizaExistenta.getIdAnalize());
                db.getAnalizeDAO().updateAnalize(newAnaliza);
                Toast.makeText(this, "Analiza actualizată cu succes!", Toast.LENGTH_SHORT).show();
            } else {
                db.getAnalizeDAO().insertAnalize(newAnaliza);
                Toast.makeText(this, "Analiza adăugată cu succes!", Toast.LENGTH_SHORT).show();
            }

            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
