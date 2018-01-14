package ru.atc_consulting.clientapp.adapters;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.domain.Cargo;
import ru.atc_consulting.clientapp.domain.Special;


public class SpecialAdapter extends ArrayAdapter<Special> {
    private final LayoutInflater mInflater;

    public SpecialAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_2);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Special> data) {
        clear();
        if (data != null) {
            for (Special appEntry : data) {
                add(appEntry);
            }
        }
    }

    /**
     * Populate new items in the list.
     */
    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.adapter_item_special, parent, false);
        } else {
            view = convertView;
        }

        Special item = getItem(position);
        ((TextView)view.findViewById(R.id.tv_date)).setText(item.getDate());
        ((TextView)view.findViewById(R.id.tv_text)).setText(item.getText());
        view.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.helpful_item));

        return view;
    }
}
