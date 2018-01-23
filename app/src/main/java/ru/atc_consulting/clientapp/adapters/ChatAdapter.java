package ru.atc_consulting.clientapp.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.domain.Message;


public class ChatAdapter extends ArrayAdapter<Message> {
    private final LayoutInflater mInflater;

    public ChatAdapter(Context context, List<Message> data) {
        super(context, android.R.layout.simple_list_item_2, data);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Populate new items in the list.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.adapter_item_message, parent, false);
        } else {
            view = convertView;
        }

        Message item = getItem(position);
        ((TextView) view.findViewById(R.id.message_user)).setText(item.getUser());
        ((TextView) view.findViewById(R.id.message_date)).setText(item.getDate());
        ((TextView) view.findViewById(R.id.message_time)).setText(item.getTime());
        ((TextView) view.findViewById(R.id.message_text)).setText(item.getText());

        return view;
    }
}
