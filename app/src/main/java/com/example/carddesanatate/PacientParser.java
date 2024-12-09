package com.example.carddesanatate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PacientParser {
    private static final String NUME = "nume";
    private static final String PRENUME = "prenume";
    private static final String CODNUMERICPERSONAL = "CNP";
    private static final String EMAIL = "email";

    public static List<Pacient> parsareJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parsarePacienti(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Pacient> parsarePacienti(JSONArray jsonArray) throws JSONException {
        List<Pacient> pacienti = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            pacienti.add(parsarePacient(jsonArray.getJSONObject(i)));
        }
        return pacienti;
    }

    private static Pacient parsarePacient(JSONObject jsonObject) throws JSONException {
        String nume = jsonObject.getString(NUME);
        String prenume = jsonObject.getString(PRENUME);
        String CNP = jsonObject.getString(CODNUMERICPERSONAL);
        String email = jsonObject.getString(EMAIL);

        return new Pacient(nume, prenume, CNP, email);
    }
}
