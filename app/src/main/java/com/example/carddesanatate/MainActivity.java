package com.example.carddesanatate;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button bttnConectare;
    Button bttnAmUitatParola;
    Button bttnInregistrare;

    EditText etEmail;
    EditText etParola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bttnInregistrare = findViewById(R.id.bttnInregistrare);
        bttnConectare = findViewById(R.id.bttnConectare);
        bttnAmUitatParola=findViewById(R.id.bttnAmUitatParola);
        etEmail = findViewById(R.id.etEmail);
        etParola = findViewById(R.id.etParola);

//        bttnInregistrare.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, Login.class);
//            startActivity(intent);
//        });


    }
}