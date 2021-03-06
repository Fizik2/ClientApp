package ru.atc_consulting.clientapp.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.fragments.helpful.AviaFragment;
import ru.atc_consulting.clientapp.fragments.helpful.ComplexFragment;
import ru.atc_consulting.clientapp.fragments.helpful.ContainerFragment;
import ru.atc_consulting.clientapp.fragments.helpful.GFragment;
import ru.atc_consulting.clientapp.fragments.helpful.MoscowFragment;
import ru.atc_consulting.clientapp.fragments.helpful.PekinFragment;
import ru.atc_consulting.clientapp.fragments.helpful.SpecialFragment;

import static android.app.Activity.RESULT_OK;

public class HelpfulFragment extends Fragment {

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_helpful, container, false);

        RelativeLayout item_avia = (RelativeLayout) mView.findViewById(R.id.item_avia);
        RelativeLayout item_complex = (RelativeLayout) mView.findViewById(R.id.item_complex);
        RelativeLayout item_container = (RelativeLayout) mView.findViewById(R.id.item_container);

        RelativeLayout item_speсial = (RelativeLayout) mView.findViewById(R.id.item_special);
        RelativeLayout item_moscow = (RelativeLayout) mView.findViewById(R.id.item_moscow);
        RelativeLayout item_pekin = (RelativeLayout) mView.findViewById(R.id.item_pekin);
        RelativeLayout item_g = (RelativeLayout) mView.findViewById(R.id.item_g);


        item_avia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.root_frame_helpful, new AviaFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        item_complex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.root_frame_helpful, new ComplexFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        item_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.root_frame_helpful, new ContainerFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        item_speсial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.root_frame_helpful, new SpecialFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });


        item_moscow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.root_frame_helpful, new MoscowFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        item_pekin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.root_frame_helpful, new PekinFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        item_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(R.id.root_frame_helpful, new GFragment());
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });

        return mView;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}