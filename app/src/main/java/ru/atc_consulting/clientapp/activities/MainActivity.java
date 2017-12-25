package ru.atc_consulting.clientapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.adapters.BottomBarAdapter;
import ru.atc_consulting.clientapp.domain.User;
import ru.atc_consulting.clientapp.fragments.RequestFragment;
import ru.atc_consulting.clientapp.fragments.TrackerFragment;
import ru.atc_consulting.clientapp.help.NoSwipePager;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NoSwipePager mPager;
    private BottomBarAdapter mPagerAdapter;
    private AHBottomNavigation mBottomNavigationView;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Left menu starts
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.side_nav_bar);


        // bottom navigation menu
        mBottomNavigationView = (AHBottomNavigation)
                findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                if (!wasSelected)
                    mPager.setCurrentItem(position);

            }
        });
        addBottomNavigationItems();

        // view pager
        mPager = (NoSwipePager) findViewById(R.id.pager);
        mPager.setPagingEnabled(false);
        mPagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        // add fragments
        TrackerFragment trackerFragment = new TrackerFragment();
        mPagerAdapter.addFragments(trackerFragment);
        RequestFragment requestFragment = new RequestFragment();
        mPagerAdapter.addFragments(requestFragment);

        // set adapter
        mPager.setAdapter(mPagerAdapter);
    }

    private void addBottomNavigationItems() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(getResources().getString(R.string.tracker_navigation), android.R.drawable.ic_dialog_email);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(getResources().getString(R.string.request_navigation), android.R.drawable.ic_dialog_email);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(getResources().getString(R.string.useful_navigation), android.R.drawable.ic_dialog_email);

        mBottomNavigationView.addItem(item1);
        mBottomNavigationView.addItem(item2);
        mBottomNavigationView.addItem(item3);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.nav_loyalty) {

        } else if (id == R.id.nav_call) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        User user = User.getAuthorizedUser(this);
        if (user == null) {
            mNavigationView.getMenu().findItem(R.id.nav_login).setVisible(true);
            mNavigationView.getMenu().findItem(R.id.nav_loyalty).setVisible(true);
            mNavigationView.getMenu().findItem(R.id.nav_status).setVisible(false);
            mNavigationView.getMenu().findItem(R.id.nav_name).setVisible(false);
        } else {
            mNavigationView.getMenu().findItem(R.id.nav_name).setTitle(user.getLogin());
            mNavigationView.getMenu().findItem(R.id.nav_login).setVisible(false);
            mNavigationView.getMenu().findItem(R.id.nav_loyalty).setVisible(false);
            mNavigationView.getMenu().findItem(R.id.nav_status).setVisible(true);
            mNavigationView.getMenu().findItem(R.id.nav_name).setVisible(true);
        }
    }
}

