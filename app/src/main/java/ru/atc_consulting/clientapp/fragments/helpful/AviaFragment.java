package ru.atc_consulting.clientapp.fragments.helpful;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.domain.Cargo;

public class AviaFragment extends Fragment {

    public AviaFragment(){

    }

    private View mView;
    private Cargo mCargo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_helpful_avia, container, false);
        return mView;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}