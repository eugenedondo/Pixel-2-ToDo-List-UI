package com.eugenedondo.todolistingui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        List<ItemModel> list = new ArrayList<>();
        list.add(new ItemModel("Meetings this week", "12 Meetings", R.color.colorItem1, true ));
        list.add(new ItemModel("Birthdays this week", "2 friends", R.color.colorItem2, true));
        list.add(new ItemModel("Buy Groceries", "7 items", R.color.colorItem3, false ));
        list.add(new ItemModel("Appointments", "4 appointments", R.color.colorItem4, true ));
        list.add(new ItemModel("Parties this month", "3 parties", R.color.colorItem5, false ));
        list.add(new ItemModel("Replies of emails", "12 Emails", R.color.colorItem6, true ));

        RecyclerView mRecyclerView = findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        TodoAdapter.RecyclerViewClickListener listener = new TodoAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
            }
        };

        TodoAdapter adapter = new TodoAdapter(list, getApplicationContext(), listener);
        mRecyclerView.setAdapter(adapter);

    }

    public void openSettings(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }
}
