package com.example.carddesanatate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgramareParser {
    private static final String ID_PACIENT = "idPacient";
    private static final String ID_MEDIC = "idMedic";
    private static final String CNP_PACIENT = "CNPPacient";
    private static final String DATA_PROGRAMARII = "dataProgramarii";
    private static final String ORA_PROGRAMARII = "oraProgramarii";
    private static final String DENUMIRE_SPITAL = "denumireSpital";
    private static final String NUME_MEDIC = "numeMedic";

    public static List<Programare> parsareJson(String json) {
        try {
            JSONArray jsonArray = new JSONArray(json);
            return parsareProgramari(jsonArray);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Programare> parsareProgramari(JSONArray jsonArray) throws JSONException {
        List<Programare> programari = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            programari.add(parsareProgramare(jsonArray.getJSONObject(i)));
        }
        return programari;
    }

    private static Programare parsareProgramare(JSONObject jsonObject) throws JSONException {
        int idPacient = jsonObject.getInt(ID_PACIENT);
        int idMedic = jsonObject.getInt(ID_MEDIC);
        String CNPPacient = jsonObject.getString(CNP_PACIENT);
        Date dataProgramarii = new Date(jsonObject.getLong(DATA_PROGRAMARII));
        String oraProgramarii = jsonObject.getString(ORA_PROGRAMARII);
        String denumireSpital = jsonObject.getString(DENUMIRE_SPITAL);
        String numeMedic = jsonObject.getString(NUME_MEDIC);

        return new Programare(idPacient, idMedic, CNPPacient, dataProgramarii, oraProgramarii, denumireSpital, numeMedic);
    }
}
