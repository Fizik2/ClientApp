package ru.atc_consulting.clientapp.activities;

import android.app.Activity;
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
import ru.atc_consulting.clientapp.fragments.CabinetRootFragment;
import ru.atc_consulting.clientapp.fragments.ChatFragment;
import ru.atc_consulting.clientapp.fragments.HelpfulRootFragment;
import ru.atc_consulting.clientapp.fragments.RequestFragment;
import ru.atc_consulting.clientapp.fragments.TrackerFragment;
import ru.atc_consulting.clientapp.help.NoSwipePager;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NoSwipePager mPager;
    private BottomBarAdapter mPagerAdapter;
    private AHBottomNavigation mBottomNavigationView;
    private NavigationView mNavigationLeftView;
    private AHBottomNavigationItem mTrackerBottomNavItem;
    private AHBottomNavigationItem mCabinetBottomNavItem;
    private AHBottomNavigationItem mBottomNavItem2, mBottomNavItem3, mBottomNavItem4, mBottomNavItem5;
    private Activity mActivity = this;

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

        mNavigationLeftView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationLeftView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.side_nav_bar);


        // bottom navigation menu
        mTrackerBottomNavItem = new AHBottomNavigationItem(getResources().getString(R.string.tracker_navigation), android.R.drawable.ic_dialog_email);
        mCabinetBottomNavItem = new AHBottomNavigationItem(getResources().getString(R.string.cabinet_navigation), android.R.drawable.ic_dialog_email);
        mBottomNavItem2 = new AHBottomNavigationItem(getResources().getString(R.string.request_navigation), android.R.drawable.ic_dialog_email);
//        mBottomNavItem3 = new AHBottomNavigationItem(getResources().getString(R.string.calc_navigation), android.R.drawable.ic_dialog_email);
        mBottomNavItem4 = new AHBottomNavigationItem(getResources().getString(R.string.chat_navigation), android.R.drawable.ic_dialog_email);
        mBottomNavItem5 = new AHBottomNavigationItem(getResources().getString(R.string.useful_navigation), android.R.drawable.ic_dialog_email);


        mBottomNavigationView = (AHBottomNavigation)
                findViewById(R.id.bottom_navigation);
        mBottomNavigationView.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        mBottomNavigationView.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // На нулевом месте в mPager идёт личный кабинет, на первом трекер и тд
                if (!wasSelected) {
                    if (position == 0) {
                        if (User.getAuthorizedUser(mActivity) == null) {
                            mPager.setCurrentItem(1);
                        } else {
                            mPager.setCurrentItem(0);
                        }
                    } else {
                        mPager.setCurrentItem(position + 1);
                    }
                }
                return true;
            }

        });

        // view pager
        mPager = (NoSwipePager) findViewById(R.id.pager);
        mPager.setPagingEnabled(false);
        mPagerAdapter = new BottomBarAdapter(getSupportFragmentManager());

        // add fragments
        // На нулевом месте в mPager идёт личный кабинет, на первом трекер и тд
        CabinetRootFragment cabinetFragment = new CabinetRootFragment();
        mPagerAdapter.addFragments(cabinetFragment);
        TrackerFragment trackerFragment = new TrackerFragment();
        mPagerAdapter.addFragments(trackerFragment);
        RequestFragment requestFragment = new RequestFragment();
        mPagerAdapter.addFragments(requestFragment);
        ChatFragment chatFragment = new ChatFragment();
        mPagerAdapter.addFragments(chatFragment);
        HelpfulRootFragment helpfulRootFragment = new HelpfulRootFragment();
        mPagerAdapter.addFragments(helpfulRootFragment);


        // set adapter
        mPager.setAdapter(mPagerAdapter);

    }

    private void addBottomNavigationItemsWithoutFirst() {
        mBottomNavigationView.addItem(mBottomNavItem2);
        mBottomNavigationView.addItem(mBottomNavItem4);
        mBottomNavigationView.addItem(mBottomNavItem5);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

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
        if (mBottomNavigationView.getItemsCount() > 0)
            mBottomNavigationView.removeAllItems();


        if (user == null) {
            mNavigationLeftView.getMenu().findItem(R.id.nav_login).setVisible(true);
            mNavigationLeftView.getMenu().findItem(R.id.nav_loyalty).setVisible(true);
            mNavigationLeftView.getMenu().findItem(R.id.nav_status).setVisible(false);
            mNavigationLeftView.getMenu().findItem(R.id.nav_name).setVisible(false);
            mBottomNavigationView.addItem(mTrackerBottomNavItem);

            if (mBottomNavigationView.getCurrentItem() == 0 || mBottomNavigationView.getCurrentItem() == 1)
                mPager.setCurrentItem(1);

        } else {
            mNavigationLeftView.getMenu().findItem(R.id.nav_name).setTitle(user.getLogin());
            mNavigationLeftView.getMenu().findItem(R.id.nav_login).setVisible(false);
            mNavigationLeftView.getMenu().findItem(R.id.nav_loyalty).setVisible(false);
            mNavigationLeftView.getMenu().findItem(R.id.nav_status).setVisible(true);
            mNavigationLeftView.getMenu().findItem(R.id.nav_name).setVisible(true);
            mBottomNavigationView.addItem(mCabinetBottomNavItem);

            if (mBottomNavigationView.getCurrentItem() == 0 || mBottomNavigationView.getCurrentItem() == 1)
                mPager.setCurrentItem(0);
        }
        addBottomNavigationItemsWithoutFirst();
    }
}

