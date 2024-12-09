package com.example.carddesanatate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

public class IstoricAnalizeActivity extends AppCompatActivity {

    private ListView lsvAnalize;
    private List<Analize> analizeList = new ArrayList<>();
    private ActivityResultLauncher<Intent> launcher;
    private int position;
    private AnalizeDB analizeDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_istoric_analize);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lsvAnalize = findViewById(R.id.lsvAnalize);
        analizeDB = AnalizeDB.getInstance(getApplicationContext());
        analizeList = analizeDB.getAnalizeDAO().getAllAnalize();

        lsvAnalize.setOnItemClickListener((adapterView, view, position, l) -> {
            this.position = position;
            Intent intent = new Intent(getApplicationContext(), AdaugaAnalizeActivity.class);
            intent.putExtra("edit", analizeList.get(position));
            launcher.launch(intent);
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getData() != null) {
                if (result.getData().hasExtra("analizaFromIntent")) {
                    Analize newAnaliza = (Analize) result.getData().getSerializableExtra("analizaFromIntent");
                    if (newAnaliza != null) {
                        analizeList.add(newAnaliza);
                        AnalizeAdapter adapter = (AnalizeAdapter) lsvAnalize.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else if (result.getData().hasExtra("edit")) {
                    Analize editedAnalize = (Analize) result.getData().getSerializableExtra("edit");
                    if (editedAnalize != null) {
                        Analize analiza = analizeList.get(position);
                        analiza.setNumeAnalize(editedAnalize.getNumeAnalize());
                        analiza.setCNP(editedAnalize.getCNP());
                        analiza.setDenumireSpital(editedAnalize.getDenumireSpital());
                        analiza.setNumeMedic(editedAnalize.getNumeMedic());
                        analiza.setNumePacient(editedAnalize.getNumePacient());
                        analiza.setPrenumePacient(editedAnalize.getPrenumePacient());
                        analiza.setSectieSptial(editedAnalize.getSectieSptial());
                        AnalizeAdapter adapter = (AnalizeAdapter) lsvAnalize.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("local", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", "Token");
        editor.apply();

        FloatingActionButton fabAdaugareAnaliza = findViewById(R.id.fabAdaugareAnaliza);
        fabAdaugareAnaliza.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AdaugaAnalizeActivity.class);
            launcher.launch(intent);
        });

        AnalizeAdapter adapter = new AnalizeAdapter(getApplicationContext(), R.layout.view_analize, analizeList, getLayoutInflater());
        lsvAnalize.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
