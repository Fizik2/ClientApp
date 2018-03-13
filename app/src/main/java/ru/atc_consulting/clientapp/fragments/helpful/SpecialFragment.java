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
        specials.add(new Special("12.10.2016", "Бесплатный профессиональный поиск производителей в Китае и Вьетнаме"));
        specials.add(new Special("09.09.2016", "Перевозка сборных грузов из Китая от 135$/куб! При отправке с ATC C&L хранение груза на складе консолидации БЕСПЛАТНО! "));
        specials.add(new Special("15.08.2016", "ATC C&L объявляет конкурс! Получи подарок за публикацию!"));
        specials.add(new Special("02.08.2016", "Еженедельная отправка сборного контейнера с нашего консолидационного склада из Гуанчжоу. Успейте забронировать место!"));
        specials.add(new Special("06.06.2016", "18 июня отправка сборного контейнера с нашего консолидационного склада из Гаунчжоу. Успейте забронировать место!"));
        specials.add(new Special("18.05.2016", "28 мая отправка сборного контейнера с нашего консолидационного склада из Гаунчжоу. Успейте забронировать место!"));
        specials.add(new Special("02.11.2015", "Снижение стоимости железнодорожной перевозки через Забайкальск до конца ноября!"));

        SpecialAdapter adapter = new SpecialAdapter(getActivity());
        adapter.setData(specials);
        this.setListAdapter(adapter);

    }

}