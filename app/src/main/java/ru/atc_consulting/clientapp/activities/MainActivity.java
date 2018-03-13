package ru.atc_consulting.clientapp.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.adapters.BottomBarAdapter;
import ru.atc_consulting.clientapp.adapters.CabinetAdapter;
import ru.atc_consulting.clientapp.domain.Cargo;
import ru.atc_consulting.clientapp.domain.User;
import ru.atc_consulting.clientapp.fragments.CabinetFragment;
import ru.atc_consulting.clientapp.fragments.CabinetRootFragment;
import ru.atc_consulting.clientapp.fragments.DeliveryDetailsFragment;
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
    private AHBottomNavigationItem mBottomNavItem2, mBottomNavItem3;
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
        mBottomNavItem3 = new AHBottomNavigationItem(getResources().getString(R.string.useful_navigation), android.R.drawable.ic_dialog_email);


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
                            setTitle("Трекер");
                        } else {
                            if (cabinetFragment != null) {
                                cabinetFragment.updateList();
                            }
                            mPager.setCurrentItem(0);
                            setTitle("Личный кабинет");

                        }
                    } else {
                        mPager.setCurrentItem(position + 1);
                        if (position == 1) {
                            setTitle("Заявка на расчёт");
                        } else if (position == 2) {
                            setTitle("Полезное");
                        }
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
        HelpfulRootFragment helpfulRootFragment = new HelpfulRootFragment();
        mPagerAdapter.addFragments(helpfulRootFragment);


        // set adapter
        mPager.setAdapter(mPagerAdapter);


    }

    private void addBottomNavigationItemsWithoutFirst() {
        mBottomNavigationView.addItem(mBottomNavItem2);
        mBottomNavigationView.addItem(mBottomNavItem3);
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
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            startActivity(new Intent(this, LoginActivity.class));
        } else if (id == R.id.nav_loyalty) {
        } else if (id == R.id.nav_call) {
            Intent phoneIntent = new Intent(Intent.ACTION_CALL);
            phoneIntent.setData(Uri.parse("tel:+7-495-215-2473"));

            if (ActivityCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 123);
                return false;
            }


            startActivity(phoneIntent);


        } else if (id == R.id.nav_logout)

        {
            User.logout(this);
            startActivity(new Intent(this, MainActivity.class));
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 123: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                    phoneIntent.setData(Uri.parse("tel:+7-495-215-2473"));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(phoneIntent);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
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
            mNavigationLeftView.getMenu().findItem(R.id.nav_logout).setVisible(false);
            mBottomNavigationView.addItem(mTrackerBottomNavItem);

            if (mBottomNavigationView.getCurrentItem() == 0 || mBottomNavigationView.getCurrentItem() == 1)
                mPager.setCurrentItem(1);

        } else {
            mNavigationLeftView.getMenu().findItem(R.id.nav_name).setTitle(user.getLogin());
            mNavigationLeftView.getMenu().findItem(R.id.nav_login).setVisible(false);
            mNavigationLeftView.getMenu().findItem(R.id.nav_loyalty).setVisible(false);
            mNavigationLeftView.getMenu().findItem(R.id.nav_status).setVisible(true);
            mNavigationLeftView.getMenu().findItem(R.id.nav_name).setVisible(true);
            mNavigationLeftView.getMenu().findItem(R.id.nav_logout).setVisible(true);

            mBottomNavigationView.addItem(mCabinetBottomNavItem);

            if (mBottomNavigationView.getCurrentItem() == 0 || mBottomNavigationView.getCurrentItem() == 1)
                mPager.setCurrentItem(0);
        }
        addBottomNavigationItemsWithoutFirst();
        mBottomNavigationView.setCurrentItem(0, true);
        if (User.getAuthorizedUser(mActivity) == null) {
            setTitle("Трекер");
        } else {
            setTitle("Личный кабинет");
        }


        //        List<Cargo> cargos = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            List<String> placesHistory = new ArrayList<>();
//            placesHistory.add("20.01 - На станции назначении");
//            placesHistory.add("08.01 - Движение по ЖД");
//            placesHistory.add("01.01 - Ожидает ЖД");
//            placesHistory.add("28.12 - Таможенное оформление");
//            placesHistory.add("10.12 - В порту");
//            placesHistory.add("01.12 - В море");
//            placesHistory.add("03.11 - У отправителя");
//            cargos.add(new Cargo("id 123456789", "ДТ выпущена", "Москва", placesHistory));
//        }

        if (cabinetFragment != null) {
            cabinetFragment.updateList();
        }
    }

    public static CabinetFragment cabinetFragment;
}

