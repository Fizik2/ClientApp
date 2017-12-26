package ru.atc_consulting.clientapp.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.domain.Cargo;



public class CabinetAdapter extends ArrayAdapter<Cargo> {
    private final LayoutInflater mInflater;

    public CabinetAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_2);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Cargo> data) {
        clear();
        if (data != null) {
            for (Cargo appEntry : data) {
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
            view = mInflater.inflate(R.layout.adapter_item_cabinet, parent, false);
        } else {
            view = convertView;
        }

        Cargo item = getItem(position);
        ((TextView)view.findViewById(R.id.tv_id)).setText(item.getId());
        ((TextView)view.findViewById(R.id.tv_last_place)).setText(item.getLastPlace());
        ((TextView)view.findViewById(R.id.tv_status)).setText(item.getStatus());

        return view;
    }
}
