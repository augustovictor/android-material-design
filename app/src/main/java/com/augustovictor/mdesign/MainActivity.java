package com.augustovictor.mdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.augustovictor.mdesign.Adapter.RecyclerAdapter;
import com.augustovictor.mdesign.Model.Landscape;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {

    Toolbar mToolbar;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Welcome!");
        mToolbar.setSubtitle("Folks! (CardViews)");

        mToolbar.inflateMenu(R.menu.menu_main);

        mToolbar.setOnMenuItemClickListener(this);

        setUpRecyclerView();

    }

    private void setUpRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Landscape.getData());
        mRecyclerView.setAdapter(adapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_linear_view_h:
                LinearLayoutManager mLayoutManagerH = new LinearLayoutManager(this);
                mLayoutManagerH.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(mLayoutManagerH);
                return true;

            case R.id.menu_linear_view_v:
                LinearLayoutManager mLayoutManagerV = new LinearLayoutManager(this);
                mLayoutManagerV.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManagerV);
                return true;

            case R.id.menu_grid_view:
                GridLayoutManager mLayoutManagerG = new GridLayoutManager(this, 2);
                mRecyclerView.setLayoutManager(mLayoutManagerG);
                return true;

            case R.id.menu_staggered_view_h:
                StaggeredGridLayoutManager mLayoutManagerSH = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(mLayoutManagerSH);
                return true;

            case R.id.menu_staggered_view_v:
                StaggeredGridLayoutManager mLayoutManagerSV = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManagerSV);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
