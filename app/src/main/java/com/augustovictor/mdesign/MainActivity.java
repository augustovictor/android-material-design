package com.augustovictor.mdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.augustovictor.mdesign.Adapter.RecyclerAdapter;
import com.augustovictor.mdesign.Model.Landscape;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome!");
        toolbar.setSubtitle("Folks! (CardViews)");

        toolbar.inflateMenu(R.menu.menu_main);

        setUpRecyclerView();

    }

    private void setUpRecyclerView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter mRecyclerAdapter = new RecyclerAdapter(this, Landscape.getData());
        mRecyclerView.setAdapter(mRecyclerAdapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

}
