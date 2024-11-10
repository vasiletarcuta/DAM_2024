package com.example.carddesanatate;

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

public class IstoricAnalizeActivity extends AppCompatActivity {

    private ListView lsvAnalize;
    private List<Analize> analizeList = new ArrayList<>();
    private ActivityResultLauncher<Intent> launcher;
    private int position;

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

        lsvAnalize.setOnItemClickListener((adapterView, view, position, l) -> {
            this.position = position;
            Intent intent = new Intent(getApplicationContext(), AdaugaAnalizeActivity.class);
            intent.putExtra("edit", analizeList.get(position));
            launcher.launch(intent);
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getData().hasExtra("analizaFromIntent")) {
                Intent intent = result.getData();
                if (intent != null) {
                    Analize newAnaliza = (Analize) intent.getSerializableExtra("analizaFromIntent");
                    if (newAnaliza != null) {
                        analizeList.add(newAnaliza);
                    }
                    //ArrayAdapter<Analize> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, analizeList);
                    AnalizeAdapter adapter = new AnalizeAdapter(getApplicationContext(), R.layout.view_analize, analizeList, getLayoutInflater());
                    lsvAnalize.setAdapter(adapter);
                }
            } else if (result.getData().hasExtra("edit")) {
                    Intent intent = result.getData();
                    Analize editedAnalize = (Analize) intent.getSerializableExtra("edit");
                        if(editedAnalize!=null){
                            Analize analiza = analizeList.get(position);

                            analiza.setNumeAnalize(editedAnalize.getNumeAnalize());
                            analiza.setCNP(editedAnalize.getCNP());
                            analiza.setDenumireSpital(editedAnalize.getDenumireSpital());
                            analiza.setNumeMedic(editedAnalize.getNumeMedic());
                            analiza.setNumePacient(editedAnalize.getNumePacient());
                            analiza.setPrenumePacient(editedAnalize.getPrenumePacient());
                            analiza.setSectieSptial(editedAnalize.getSectieSptial());
                            AnalizeAdapter adapter = (AnalizeAdapter) lsvAnalize.getAdapter();
                            adapter.notifyDataSetChanged();
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

    }
}