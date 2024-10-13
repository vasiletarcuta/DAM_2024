package com.example.carddesanatate;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Home extends AppCompatActivity {

    Button bttnCardDeSanatate;
    Button bttnVerificareCalitateAsigurat;
    Button bttnIstoricAnalize;
    Button bttnProgramari;


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

    }
}