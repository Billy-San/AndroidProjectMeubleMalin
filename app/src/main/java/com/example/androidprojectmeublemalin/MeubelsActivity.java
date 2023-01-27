package com.example.androidprojectmeublemalin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class MeubelsActivity extends AppCompatActivity {



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navtoform, menu);
        return true;}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_list:
                Intent intent = new Intent(MeubelsActivity.this,MeubleAddActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);}

    RecyclerView recyclerView;
    EigenAdapter adapter;
    ArrayList<Meuble> list;

    DbHelper firebaseHelper = DbHelper.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meubels);
        recyclerView = findViewById(R.id.listmeuble);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Meuble>();
        adapter = new EigenAdapter(this,list);
        recyclerView.setAdapter(adapter);
        firebaseHelper.addValueEventListener(new DbHelper.FirebaseCallback() {
            @Override
            public void onCallback(DataSnapshot snapshot) {
                for(DataSnapshot meubleSnap : snapshot.getChildren()){
                    Meuble meuble = meubleSnap.getValue(Meuble.class);
                    list.add(meuble);
                    adapter.notifyItemInserted(list.size()-1);
                }            adapter.notifyDataSetChanged();
            }
        });
    }

}