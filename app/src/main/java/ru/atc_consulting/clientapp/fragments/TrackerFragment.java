package ru.atc_consulting.clientapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import ru.atc_consulting.clientapp.R;

public class TrackerFragment extends Fragment {

    private View mView;
    private TextView mTrackerText;
    private Button mTrackerButton;
    private TextView mTrackerLastPlacePrompt;
    private TextView mTrackerLastPlaceText;
    private TextView mTrackerStatusPrompt;
    private TextView mTrackerStatusText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_tracker, container, false);

        mTrackerText = (TextView) mView.findViewById(R.id.tracker_text);

        mTrackerButton = (Button) mView.findViewById(R.id.tracker_button);
        mTrackerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mTrackerLastPlacePrompt.setVisibility(View.VISIBLE);
                mTrackerLastPlaceText.setVisibility(View.VISIBLE);
                mTrackerStatusPrompt.setVisibility(View.VISIBLE);
                mTrackerStatusText.setVisibility(View.VISIBLE);

                mTrackerLastPlaceText.setText("Москва");
                mTrackerStatusText.setText("ДТ выпущена");
            }
        });

        mTrackerLastPlacePrompt = (TextView) mView.findViewById(R.id.tracker_last_place_prompt);
        mTrackerLastPlaceText = (TextView) mView.findViewById(R.id.tracker_last_place_text);
        mTrackerStatusPrompt = (TextView) mView.findViewById(R.id.tracker_status_prompt);
        mTrackerStatusText = (TextView) mView.findViewById(R.id.tracker_status_text);


        return mView;
    }
}