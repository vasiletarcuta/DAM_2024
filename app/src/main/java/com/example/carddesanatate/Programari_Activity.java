package com.example.carddesanatate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private int position;

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

        lvProgramari.setOnItemClickListener((adapterView, view, position, l) -> {
            this.position = position;
            Intent intent = new Intent(getApplicationContext(), AdaugProgramareActivity.class);
            intent.putExtra("editProgramari", programari.get(position));
            launcher.launch(intent);
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getData().hasExtra("programareFromIntent")) {
                Intent intent = result.getData();

                if (intent != null) {
                    Programare programare = (Programare) intent.getSerializableExtra("programareFromIntent");
                    if(programare!=null){
                        programari.add(programare);
                    }
                    //ArrayAdapter<Programare> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, programari);
                    ProgramareAdapter adapter = new ProgramareAdapter(getApplicationContext(), R.layout.view_programare, programari, getLayoutInflater());
                    lvProgramari.setAdapter(adapter);
                }
            } else if(result.getData().hasExtra("editProgramari")){
                Intent intent = result.getData();
                Programare editedAnalize = (Programare) intent.getSerializableExtra("editProgramari");
                if(editedAnalize!=null){
                    Programare programare = programari.get(position);

                    programare.setCNPPacient(editedAnalize.getCNPPacient());
                    programare.setDenumireSpital(editedAnalize.getDenumireSpital());
                    programare.setDataProgramarii(editedAnalize.getDataProgramarii());
                    programare.setNumeMedic(editedAnalize.getNumeMedic());
                    programare.setOraProgramarii(editedAnalize.getOraProgramarii());

                    ProgramareAdapter adapter = (ProgramareAdapter) lvProgramari.getAdapter();
                    adapter.notifyDataSetChanged();
                }
            }
        });


        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", "Token");
        editor.apply();

        fabAdaugProgramare = findViewById(R.id.fabAdaugaProgramare);
        fabAdaugProgramare.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AdaugProgramareActivity.class);
            launcher.launch(intent);
        });
    }
}