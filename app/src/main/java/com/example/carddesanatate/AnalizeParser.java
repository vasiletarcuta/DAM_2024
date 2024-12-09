package com.example.carddesanatate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnalizeParser {
    private static final String ID_PACIENT = "idPacient";
    private static final String NUME_ANALIZE = "numeAnalize";
    private static final String DENUMIRE_SPITAL = "denumireSpital";
    private static final String NUME_PACIENT = "numePacient";
    private static final String PRENUME_PACIENT = "prenumePacient";
    private static final String CODNUMERICPERSONAL = "CNP";
    private static final String NUME_MEDIC = "numeMedic";
    private static final String SECTIE_SPITAL = "sectieSpital";

    public static List<Analize> parsareJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parsareAnalize(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Analize> parsareAnalize(JSONArray jsonArray) throws JSONException {
        List<Analize> analize = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            analize.add(parsareAnaliza(jsonArray.getJSONObject(i)));
        }
        return analize;
    }

    private static Analize parsareAnaliza(JSONObject jsonObject) throws JSONException {
        int idPacient = jsonObject.getInt(ID_PACIENT);
        String numeAnalize = jsonObject.getString(NUME_ANALIZE);
        String denumireSpital = jsonObject.getString(DENUMIRE_SPITAL);
        String numePacient = jsonObject.getString(NUME_PACIENT);
        String prenumePacient = jsonObject.getString(PRENUME_PACIENT);
        String CNP = jsonObject.getString(CODNUMERICPERSONAL);
        String numeMedic = jsonObject.getString(NUME_MEDIC);
        String sectieSpital = jsonObject.getString(SECTIE_SPITAL);

        return new Analize(idPacient, numeAnalize, denumireSpital, numePacient, prenumePacient, CNP, numeMedic, sectieSpital);
    }
}
