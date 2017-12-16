package ru.atc_consulting.clientapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.adapters.BottomBarAdapter;
import ru.atc_consulting.clientapp.fragments.RequestFragment;
import ru.atc_consulting.clientapp.fragments.TrackerFragment;
import ru.atc_consulting.clientapp.help.NoSwipePager;


public class MainActivity extends AppCompatActivity {

    private NoSwipePager mPager;
    private BottomBarAdapter mPagerAdapter;
    private AHBottomNavigation mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // e-mail button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

}

