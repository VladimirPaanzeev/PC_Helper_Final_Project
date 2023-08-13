package com.pc_helper_final_project;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private DrawerLayout drawer;
    private ListView list;
    private String[] array;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main );
        list = findViewById(R.id.listView);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        list.setAdapter(adapter);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new
                ArrayList<String>(Arrays.asList(array)));


    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       int id = menuItem.getItemId();
       if (id==R.id.components){
           array = getResources().getStringArray(R.array.pc_components);
           adapter.clear();
           adapter.addAll(array);
           adapter.notifyDataSetChanged();

       }
       else if (id==R.id.faiils){
           array = getResources().getStringArray(R.array.fales);
           adapter.clear();
           adapter.addAll(array);
           adapter.notifyDataSetChanged();

       }
       drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}