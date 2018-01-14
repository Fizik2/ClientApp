package ru.atc_consulting.clientapp.fragments.helpful;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.adapters.CabinetAdapter;
import ru.atc_consulting.clientapp.adapters.SpecialAdapter;
import ru.atc_consulting.clientapp.domain.Cargo;
import ru.atc_consulting.clientapp.domain.Special;

public class SpecialFragment extends ListFragment {

    public SpecialFragment() {

    }

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_helpful_special, container, false);
        return mView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<Special> specials = new ArrayList<>();
        specials.add(new Special("09.09.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме 1"));
        specials.add(new Special("12.10.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме 2"));
        specials.add(new Special("15.18.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме 3"));
        specials.add(new Special("15.18.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме 4"));
        specials.add(new Special("15.18.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме 5"));
        specials.add(new Special("15.18.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме 6"));
        specials.add(new Special("15.18.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме 7"));
        specials.add(new Special("15.18.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме 8"));

        SpecialAdapter adapter = new SpecialAdapter(getActivity());
        adapter.setData(specials);
        this.setListAdapter(adapter);

    }

}