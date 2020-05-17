package com.example.td3.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.td3.Injection;
import com.example.td3.R;
import com.example.td3.presentation.controller.MainController;
import com.example.td3.presentation.model.Coin;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController(this,
                Injection.getGson(),
                Injection.getSharedPreferences(getApplicationContext()));
        controller.onStart();


    }



    public void showList(List<Coin> coinList) {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        // define an adapter
        mAdapter = new ListAdapter(coinList, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Coin item) {
                controller.onItemClick(item);
            }
        });
        recyclerView.setAdapter(mAdapter);

    }


    public void showError() {
        Toast.makeText(getApplicationContext(), "Erreur de l'API", Toast.LENGTH_SHORT).show();
    }

    public void navigateToDetails(Coin coin) {
        Intent myIntent = new Intent(MainActivity.this, DetailActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}
