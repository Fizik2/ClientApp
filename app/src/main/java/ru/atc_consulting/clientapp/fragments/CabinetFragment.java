package ru.atc_consulting.clientapp.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.activities.MainActivity;
import ru.atc_consulting.clientapp.adapters.CabinetAdapter;
import ru.atc_consulting.clientapp.domain.Cargo;
import ru.atc_consulting.clientapp.domain.User;

import static android.app.Activity.RESULT_OK;

public class CabinetFragment extends ListFragment {

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_cabinet, container, false);

        MainActivity.cabinetFragment = this;
        return mView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateList();
    }


    private List<Cargo> data;
    CabinetAdapter adapter;

    public void updateList(){
        if(adapter == null){
            if (getActivity() == null) return;
            adapter = new CabinetAdapter(getActivity());
        }

        data = User.getCurrentCargos();
        adapter.setData(data);
        this.setListAdapter(adapter);
        updateClickListener();



        getActivity().getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        updateClickListener();
                    }
                });


    }

    private void updateClickListener(){
        try {
            final ListView lv = getListView();

            lv.setClickable(true);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Cargo cargo = (Cargo) lv.getItemAtPosition(position);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("cargo", cargo);
                    Fragment fragment = new DeliveryDetailsFragment();
                    fragment.setArguments(bundle);

                    FragmentTransaction trans = getFragmentManager().beginTransaction();
                    trans.replace(R.id.root_frame, fragment);
                    trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    trans.addToBackStack("1");


                    trans.commit();
                    Log.d("","");
                }
            });

        }catch (IllegalStateException ex){ex.printStackTrace();}
    }
}