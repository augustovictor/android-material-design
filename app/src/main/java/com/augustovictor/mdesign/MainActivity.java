package com.augustovictor.mdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome!");
        toolbar.setSubtitle("Folks! (standalone)");

        toolbar.inflateMenu(R.menu.menu_main);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                String msg = "";

                switch (item.getItemId()) {

                    case R.id.menu_delete_opt:
                        msg = "Delete option selected";
                        break;

                    case R.id.menu_search_opt:
                        msg = "Search option selected";
                        break;

                    case R.id.menu_edit_opt:
                        msg = "Edit option selected";
                        break;

                    case R.id.menu_settings_opt:
                        msg = "Settings option selected";
                        break;

                    case R.id.menu_exit_opt:
                        msg = "Exit option selected";
                        break;

                }

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                return true;
            }
        });


//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            toolbar.setElevation(10f);
//        }

    }

}
