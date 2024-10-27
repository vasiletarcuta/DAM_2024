package com.example.carddesanatate;

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

public class IstoricAnalizeActivity extends AppCompatActivity {

    private ListView lsvAnalize;
    private List<Analize> analizeList = new ArrayList<>();
    private ActivityResultLauncher<Intent> launcher;

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


        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                if (intent != null) {
                    Analize newAnaliza = (Analize) intent.getSerializableExtra("analizeFromIntent");
                    if (newAnaliza != null) {
                        analizeList.add(newAnaliza);
                        ArrayAdapter<Analize> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, analizeList);
                        lsvAnalize.setAdapter(adapter);
                    }
                }
            }
        });

        FloatingActionButton fabAdaugareAnaliza = findViewById(R.id.fabAdaugareAnaliza);
        fabAdaugareAnaliza.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AdaugaAnalizeActivity.class);
            launcher.launch(intent);
        });

    }
}