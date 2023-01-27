package com.example.androidprojectmeublemalin;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DbHelper {
    private static DbHelper instance;
    private DatabaseReference mDatabase;
    private ValueEventListener valueEventListener;
    public interface FirebaseCallback {
        void onCallback(DataSnapshot dataSnapshot);
    }private DbHelper() {
        mDatabase = FirebaseDatabase.getInstance("https://androidprojectmeublemalin-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Meubels");
    }

    public static synchronized DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();

        }
        return instance;
    }

    public void addValueEventListener(final FirebaseCallback callback){
        valueEventListener =  mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                callback.onCallback(dataSnapshot);
            }        @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void removeEventListener(){
        mDatabase.child("data").removeEventListener(valueEventListener);
    }
}
