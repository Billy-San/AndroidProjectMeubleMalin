package com.example.androidprojectmeublemalin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MeubleAddActivity extends AppCompatActivity {

    private FirebaseDatabase db;

    EditText titel,beschrijving,prijs;
    Button voegtoe;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meuble_add);

        db = FirebaseDatabase.getInstance("https://androidprojectmeublemalin-default-rtdb.europe-west1.firebasedatabase.app/");

        titel = (EditText) findViewById(R.id.title);
        beschrijving = (EditText) findViewById(R.id.beschrijving);
        prijs = (EditText) findViewById(R.id.prijs);
        voegtoe = (Button) findViewById(R.id.voegtoe);

        voegtoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tit = titel.getText().toString();
                String pr = prijs.getText().toString();
                String besch = beschrijving.getText().toString();

                Meuble meuble = new Meuble(tit, besch, pr);

                db.getReference("Meubels").child(tit).setValue(meuble);

                Intent intent = new Intent(MeubleAddActivity.this, MeubelsActivity.class);
                startActivity(intent);

            }
        });

    }
}