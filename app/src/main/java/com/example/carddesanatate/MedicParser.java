package com.example.carddesanatate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MedicParser {
    private static final String NUME = "nume";
    private static final String PRENUME = "prenume";
    private static final String SPITAL_PROVENIENTA = "spitalDeProvenienta";
    private static final String SPECIALIZARE = "specialziare";

    public static List<Medic> parsareJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parsareMedici(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Medic> parsareMedici(JSONArray jsonArray) throws JSONException {
        List<Medic> medici = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            medici.add(parsareMedic(jsonArray.getJSONObject(i)));
        }
        return medici;
    }

    private static Medic parsareMedic(JSONObject jsonObject) throws JSONException {
        String nume = jsonObject.getString(NUME);
        String prenume = jsonObject.getString(PRENUME);
        String spitalDeProvenienta = jsonObject.getString(SPITAL_PROVENIENTA);
        String specialziare = jsonObject.getString(SPECIALIZARE);

        return new Medic(nume, prenume, spitalDeProvenienta, specialziare);
    }
}
