package com.amc.applets.perfectcell.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.adapter.GiverAdapter;
import com.amc.applets.perfectcell.model.Giver;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainDonneur extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.giverListView)
    public ListView mListView;
    @Bind(R.id.emptyListGiver)
    public TextView emptyListGiverTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_donneur);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mListView.setAdapter(new GiverAdapter(this, getDateSet()));
        mListView.setEmptyView(emptyListGiverTextView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent clubIntent = new Intent(MainDonneur.this, ClubDescriptionActivity.class);
                Bundle args = new Bundle();
                args.putString("clubName", "applets");
                clubIntent.putExtra("extra", args);
                startActivity(clubIntent);
            }
        });
    }

    public ArrayList<Giver> getDateSet() {
        ArrayList<Giver> givers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Giver g = new Giver(LoremIpsum.getInstance().getName(), LoremIpsum.getInstance().getParagraphs(1, 1));
            givers.add(g);
        }
        return givers;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_donneur, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.applets) {
            Intent clubIntent = new Intent(this, ClubDescriptionActivity.class);
            Bundle args = new Bundle();
            args.putString("clubName", "applets");
            clubIntent.putExtra("extra", args);
            startActivity(clubIntent);
        } else if (id == R.id.baja) {
            Intent clubIntent = new Intent(this, ClubDescriptionActivity.class);
            Bundle args = new Bundle();
            args.putString("clubName", "baja");
            clubIntent.putExtra("extra", args);
            startActivity(clubIntent);

        } else if (id == R.id.conjure) {
            Intent clubIntent = new Intent(this, ClubDescriptionActivity.class);
            Bundle args = new Bundle();
            args.putString("clubName", "conjure");
            clubIntent.putExtra("extra", args);
            startActivity(clubIntent);

        } else if (id == R.id.Énergie) {
            Intent clubIntent = new Intent(this, ClubDescriptionActivity.class);
            Bundle args = new Bundle();
            args.putString("clubName", "Énergie ETS");
            clubIntent.putExtra("extra", args);
            startActivity(clubIntent);

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}