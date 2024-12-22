package com.example.carddesanatate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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

    private static final String jsonUrlProgramare = "https://jsonkeeper.com/b/N9ZZ";
    private FloatingActionButton fabAdaugProgramare;
    private ListView lvProgramari;
    private List<Programare> programari = new ArrayList<>();
    private ActivityResultLauncher<Intent> launcher;
    private int position;
    private ProgramareDB programareDB;

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

        programareDB = ProgramareDB.getInstance(getApplicationContext());
        lvProgramari = findViewById(R.id.lsvProgramari);
        programari = programareDB.getProgramareDAO().getAllProgramari();
        ProgramareAdapter adapter = new ProgramareAdapter(getApplicationContext(), R.layout.view_programare, programari, getLayoutInflater());
        lvProgramari.setAdapter(adapter);

        //incarcareProgramariDinRetea();

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
                    if (programare != null) {
                        programari.add(programare);
                        programareDB.getProgramareDAO().insertProgramare(programare);
                        adapter.notifyDataSetChanged();
                    }
                }
            } else if (result.getData().hasExtra("editProgramari")) {
                Intent intent = result.getData();
                Programare editedProgramare = (Programare) intent.getSerializableExtra("editProgramari");
                if (editedProgramare != null) {
                    Programare programare = programari.get(position);

                    programare.setCNPPacient(editedProgramare.getCNPPacient());
                    programare.setDenumireSpital(editedProgramare.getDenumireSpital());
                    programare.setDataProgramarii(editedProgramare.getDataProgramarii());
                    programare.setNumeMedic(editedProgramare.getNumeMedic());
                    programare.setOraProgramarii(editedProgramare.getOraProgramarii());

                    ProgramareAdapter adapter1 = (ProgramareAdapter) lvProgramari.getAdapter();
                    adapter1.notifyDataSetChanged();
                    programareDB.getProgramareDAO().updateProgramare(programare);
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


    //nu inteleg de ce nu vrea sa mearga


    private void incarcareProgramariDinRetea() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                HttpsManager manager = new HttpsManager(jsonUrlProgramare);
                String json = manager.procesare();
                new Handler(getMainLooper()).post(()->{
                    programari.addAll(ProgramareParser.parsareJson(json));
                    ArrayAdapter<Programare> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, programari);
                    lvProgramari.setAdapter(adapter);
                });
            }
        };
        thread.start();
    }
}
