package ru.atc_consulting.clientapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.adapters.CabinetAdapter;
import ru.atc_consulting.clientapp.domain.Cargo;

public class DeliveryDetailsFragment extends Fragment {

    public DeliveryDetailsFragment(){

    }

    private View mView;
    private Cargo mCargo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_delivery_details, container, false);
        mCargo = (Cargo) getArguments().getSerializable("cargo");
        LinearLayout historyContainer = (LinearLayout) mView.findViewById(R.id.delivery_container);
        for(String history : mCargo.getPlacesHistory()){
            TextView textView = new TextView(getContext());
            textView.setText(history);
            historyContainer.addView(textView);
        }

        return mView;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}