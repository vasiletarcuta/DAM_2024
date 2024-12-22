package com.example.carddesanatate;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseService {

    private final DatabaseReference reference;
    private static FirebaseService firebaseService;

    private FirebaseService() {
        reference  = FirebaseDatabase.getInstance().getReference();
    }

    public static FirebaseService getInstance(){
        if(firebaseService==null){
            synchronized (FirebaseService.class){
                if(firebaseService == null){
                    firebaseService = new FirebaseService();
                }
            }
        }
        return firebaseService;
    }

    public void insert(Pacient pacient){
        if(pacient==null || pacient.getId()!=null){
            return;
        }
        String id = reference.push().getKey();
        pacient.setId(id);

        reference.child(pacient.getId()).setValue(pacient);
    }

    public void update(Pacient pacient){
        if(pacient==null || pacient.getId()==null){
            return;
        }

        reference.child(pacient.getId()).setValue(pacient);
    }

    public void delete(Pacient pacient){
        if(pacient==null || pacient.getId()==null){
            return;
        }

        reference.child(pacient.getId()).removeValue();
    }

    public void addPacientiListener(Callback<List<Pacient>> callback){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Pacient> pacienti = new ArrayList<>();
                for(DataSnapshot data : snapshot.getChildren()){
                    Pacient pacient = data.getValue(Pacient.class);
                    if(pacient!=null){
                        pacienti.add(pacient);
                    }
                }
                callback.runOnUI(pacienti);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase", "Pacientul nu este disponibil");
            }
        });
    }
}
