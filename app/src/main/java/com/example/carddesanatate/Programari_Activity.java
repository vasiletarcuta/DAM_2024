package com.example.carddesanatate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Programari_Activity extends AppCompatActivity {

    private FloatingActionButton fabAdaugProgramare;
    private ListView lvProgramari;
    List<Programare> programari = new ArrayList<>();
    ActivityResultLauncher<Intent> launcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_programari);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvProgramari = findViewById(R.id.lsvProgramari);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                Programare programare = (Programare) intent.getSerializableExtra("programareFromIntent");
                if (programare != null) {
                    programari.add(programare);
                }
                //ArrayAdapter<Programare> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, programari);
                ProgramareAdapter adapter = new ProgramareAdapter(getApplicationContext(), R.layout.view_programare, programari, getLayoutInflater());
                lvProgramari.setAdapter(adapter);
            }
        });

        fabAdaugProgramare = findViewById(R.id.fabAdaugaProgramare);
        fabAdaugProgramare.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AdaugProgramareActivity.class);
            launcher.launch(intent);
        });
    }
}