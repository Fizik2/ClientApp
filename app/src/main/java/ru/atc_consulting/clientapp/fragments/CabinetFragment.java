package ru.atc_consulting.clientapp.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.adapters.CabinetAdapter;
import ru.atc_consulting.clientapp.domain.Cargo;

import static android.app.Activity.RESULT_OK;

public class CabinetFragment extends ListFragment {

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_cabinet, container, false);

        return mView;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<Cargo> cargos = new ArrayList<>();
        for(int i = 0; i < 15; i++){
            List<String> placesHistory = new ArrayList<>();
            placesHistory.add("20.01 - На станции назначении");
            placesHistory.add("08.01 - Движение по ЖД");
            placesHistory.add("01.01 - Ожидает ЖД");
            placesHistory.add("28.12 - Таможенное оформление");
            placesHistory.add("10.12 - В порту");
            placesHistory.add("01.12 - В море");
            placesHistory.add("03.11 - У отправителя");
            cargos.add(new Cargo("id 123456789", "ДТ выпущена", "Москва", placesHistory));
        }

        CabinetAdapter adapter = new CabinetAdapter(getActivity());
        adapter.setData(cargos);
        setListAdapter(adapter);
    }

}