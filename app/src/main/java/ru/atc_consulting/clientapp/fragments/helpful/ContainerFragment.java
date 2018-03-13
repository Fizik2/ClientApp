package ru.atc_consulting.clientapp.fragments.helpful;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import info.hoang8f.android.segmented.SegmentedGroup;
import ru.atc_consulting.clientapp.R;

public class ContainerFragment extends Fragment {

    public ContainerFragment(){

    }

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_helpful_container, container, false);
        return mView;
    }



//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        SegmentedGroup sg = ((SegmentedGroup)(getActivity().findViewById(R.id.segmented2)));
//        final Activity activity = getActivity();
//        sg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
//                if(checkedId == R.id.button21){
//                    activity.findViewById(R.id.firstAvia).setVisibility(View.VISIBLE);
//                    activity.findViewById(R.id.secondAvia).setVisibility(View.GONE);
//                } else{
//                    activity.findViewById(R.id.secondAvia).setVisibility(View.VISIBLE);
//                    activity.findViewById(R.id.firstAvia).setVisibility(View.GONE);
//                }
//
//            }
//        });
//    }

}