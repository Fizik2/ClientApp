package ru.atc_consulting.clientapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.adapters.CabinetAdapter;
import ru.atc_consulting.clientapp.domain.Cargo;

public class CabinetRootFragment extends Fragment {

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cabinet_root, container, false);

        CabinetFragment cabinetFragment = new CabinetFragment();
//        cabinetFragment.updateList();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.root_frame, cabinetFragment);
        transaction.commit();
        return view;
    }


}