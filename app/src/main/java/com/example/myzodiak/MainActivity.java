package com.example.myzodiak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Zodiak> zodiaks = new ArrayList<>();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_zodiak);
        recyclerView.setHasFixedSize(true);

        zodiaks.addAll(ZodiakDataSource.getListData());
        showRecycleList();
    }

    private void showRecycleList() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListZodiakAdapter listAdapter = new ListZodiakAdapter(zodiaks);
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnItemClickCallback(new ListZodiakAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Zodiak data) {
                showSelectedZodiak(data);
            }
        });

    }
    private void showSelectedZodiak(Zodiak zodiak) {
        Toast.makeText(this, "Kamu memilih " + zodiak.getName(), Toast.LENGTH_SHORT).show();
    }
}