package com.example.carddesanatate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    Spinner spnSex;
    Button bttnCreareCont;
    EditText etNume;
    EditText etPrenume;
    EditText etCNP;
    EditText etEmailInreg;
    EditText etParolaIntreg;
    EditText etConfirmaParolaInreg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bttnCreareCont = findViewById(R.id.bttnCreareCont);
        etNume = findViewById(R.id.etNume);
        etPrenume = findViewById(R.id.etPrenume);
        etCNP = findViewById(R.id.etCNP);
        etEmailInreg = findViewById(R.id.etEmailInreg);
        etParolaIntreg = findViewById(R.id.etParolaInreg);
        etConfirmaParolaInreg = findViewById(R.id.etConfirmaParolaInreg);
        spnSex = findViewById(R.id.spnSex);

        String[] listaValori = {getString(R.string.masculin), getString(R.string.feminin)};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listaValori);
        spnSex.setAdapter(adapter);

        bttnCreareCont.setOnClickListener(view -> {
            String nume = etNume.getText().toString().trim();
            String prenume = etPrenume.getText().toString().trim();
            String cnp = etCNP.getText().toString().trim();
            String email = etEmailInreg.getText().toString().trim();
            String parola = etParolaIntreg.getText().toString().trim();
            String confirmaParola = etConfirmaParolaInreg.getText().toString().trim();
            String sex = spnSex.getSelectedItem().toString();

            if (nume.isEmpty() || prenume.isEmpty() || cnp.isEmpty() || email.isEmpty() || parola.isEmpty() || confirmaParola.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Toate campurile trebuie completate!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!parola.equals(confirmaParola)) {
                Toast.makeText(getApplicationContext(), "Parolele nu se potrivesc", Toast.LENGTH_SHORT).show();
                return;
            }

            Pacient pacient = new Pacient(nume, prenume, cnp, email, parola, sex);
            FirebaseService.getInstance().insert(pacient);

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}