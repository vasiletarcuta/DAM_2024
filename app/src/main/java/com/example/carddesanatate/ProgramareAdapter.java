package com.example.carddesanatate;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Date;
import java.util.List;
import java.time.Instant;
public class ProgramareAdapter extends ArrayAdapter {

    private Context context;
    private List<Programare> programareList;
    private int layoutId;
    private LayoutInflater inflater;

    public ProgramareAdapter(@NonNull Context context, int resource, @NonNull List<Programare> objects, LayoutInflater inflater) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.programareList = objects;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(layoutId, parent, false);
        Programare programare = programareList.get(position);
        TextView tvCNP = view.findViewById(R.id.tvCNPPacient);
        TextView tvData = view.findViewById(R.id.tvData);
        TextView tvOra = view.findViewById(R.id.tvOra);
        TextView tvSpital = view.findViewById(R.id.tvSpital);
        TextView tvNumeMedic = view.findViewById(R.id.tvNumeMedic);

        tvCNP.setText(programare.getCNPPacient());
        tvData.setText(new SimpleDateFormat("dd/MM/yyyy").format(programare.getDataProgramarii()));
        Date data = programare.getDataProgramarii();
        tvOra.setText(programare.getOraProgramarii());
        tvSpital.setText(programare.getDenumireSpital());
        tvNumeMedic.setText(programare.getNumeMedic());

        tvSpital.setTypeface(tvNumeMedic.getTypeface(), Typeface.BOLD);
        tvSpital.setTextSize(17);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Instant instant = Instant.now();
            if(instant.isAfter(data.toInstant())){
                tvData.setTextColor(Color.RED);
            }
            else{
                tvData.setTextColor(Color.GREEN);
            }
        }

        return view;
    }
}
