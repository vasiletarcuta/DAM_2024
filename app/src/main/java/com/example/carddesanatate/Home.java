package com.example.carddesanatate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    Button bttnCardDeSanatate;
    Button bttnVerificareCalitateAsigurat;
    Button bttnIstoricAnalize;
    Button bttnProgramari, medici;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bttnCardDeSanatate = findViewById(R.id.bttnCardDeSanatate);
        bttnVerificareCalitateAsigurat = findViewById(R.id.bttnVerificareCalitateAsigurat);
        bttnIstoricAnalize = findViewById(R.id.bttnIstoricAnalize);
        bttnProgramari = findViewById(R.id.bttnProgramari);
        medici = findViewById(R.id.bttnVizMedici);

        bttnProgramari.setOnClickListener( view ->{
            Intent intent = new Intent(getApplicationContext(), Programari_Activity.class);
            startActivity(intent);
        });

        bttnIstoricAnalize.setOnClickListener( view ->{
            Intent intent = new Intent(getApplicationContext(), IstoricAnalizeActivity.class);
            startActivity(intent);
        });

        bttnVerificareCalitateAsigurat.setOnClickListener( view ->{
            Intent intent = new Intent(getApplicationContext(), VerificareCalitateAsiguratActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 1, "Modificare date");
        menu.add(0, 2, 2, "Vizualizare card de sanatate");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case 1: {
                Toast.makeText(this, "Adauga telefon", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }
}