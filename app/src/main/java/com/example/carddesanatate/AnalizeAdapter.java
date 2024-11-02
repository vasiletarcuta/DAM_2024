package com.example.carddesanatate;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Objects;

public class AnalizeAdapter extends ArrayAdapter<Analize> {

    private Context context;
    private List<Analize> analizeList;
    private int layoutId;
    private LayoutInflater inflater;


    public AnalizeAdapter(@NonNull Context context, int resource, @NonNull List<Analize> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.analizeList = objects;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layoutId, parent, false);
        Analize analize = analizeList.get(position);
        TextView tvNumeAnalize = view.findViewById(R.id.tvNumeAnalize);
        TextView tvSpital = view.findViewById(R.id.tvSpital);
        TextView tvNumePacient = view.findViewById(R.id.tvNumePacient);
        TextView tvPrenumePacient = view.findViewById(R.id.tvPrenumePacient);
        TextView tvCNP = view.findViewById(R.id.tvCNP);
        TextView tvMedic = view.findViewById(R.id.tvMedic);
        TextView tvSectie = view.findViewById(R.id.tvSectie);

        tvNumeAnalize.setText(analize.getNumeAnalize());
        tvSpital.setText(analize.getDenumireSpital());
        tvNumePacient.setText(analize.getNumePacient());
        tvPrenumePacient.setText(analize.getPrenumePacient());
        tvCNP.setText(analize.getCNP());
        tvMedic.setText(analize.getNumeMedic());
        tvSectie.setText(analize.getSectieSptial());

        if(Objects.equals(analize.getSectieSptial(), "Compartiment Cardiologie")){
            tvSectie.setTextSize(17);
            tvSectie.setTextColor(Color.CYAN);
        }

        tvNumeAnalize.setTypeface(tvNumeAnalize.getTypeface(), Typeface.BOLD_ITALIC);

        return view;
    }
}
