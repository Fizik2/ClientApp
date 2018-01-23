package ru.atc_consulting.clientapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ru.atc_consulting.clientapp.R;
import ru.atc_consulting.clientapp.adapters.ChatAdapter;
import ru.atc_consulting.clientapp.domain.Message;


public class ChatFragment extends Fragment {

    public static final String MAIL = "ndmelentev@yandex.ru";
    private static final String SAVED_MAIL = "SAVED_MAIL";
    public static Queue<Message> outMessages = new LinkedList<>();
    private View mView;
    private ListView mChat;
    private EditText mChatInput;
    private ImageButton mChatSend;

//    private List<Message> listItems = new ArrayList<>();
//    private ChatAdapter adapter = new ChatAdapter(getActivity(), listItems);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_chat, container, false);

        // Chat messages
        final List<Message> listItems = new ArrayList<>();

        // Chat adapter
        final ChatAdapter adapter = new ChatAdapter(getActivity(), listItems);

        // Chat
        mChat = (ListView) mView.findViewById(R.id.chat);
        mChat.setAdapter(adapter);

        // Chat input
        mChatInput = (EditText) mView.findViewById(R.id.chat_input);

        // Chat send
        mChatSend = (ImageButton) mView.findViewById(R.id.chat_send);
        mChatSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar c = Calendar.getInstance();
                int month = c.get(Calendar.MONTH) + 1;
                int day = c.get(Calendar.DAY_OF_MONTH);
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                String user = "Вы";
                String date = String.valueOf(day) + "." + String.valueOf(month);
                String time = String.valueOf(hour) + ":" + String.valueOf(minute);
                String text = mChatInput.getText().toString();

                listItems.add(new Message(user, date, time, text));
                adapter.notifyDataSetChanged();

                mChatInput.setText("");
                mChatInput.clearFocus();

                // save message
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(String.format("{'user':'%s', 'date':'%s', 'time':'%s', 'text':'%s'}", user, date, time, text));
                    setSavedMail(jsonObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // e-mail
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("adapter_item_message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{MAIL});
                i.putExtra(Intent.EXTRA_SUBJECT, "Чат");
                i.putExtra(Intent.EXTRA_TEXT, mChatInput.getText().toString());

                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Inflate chat
        setChatMessages(listItems, adapter);

        // run task of reading e-mails
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//
//                while (outMessages.size() != 0) {
//                    listItems.add(outMessages.remove());
//                }
//                adapter.notifyDataSetChanged();
//
//                handler.postDelayed(this, 1000); //now is every 5 minutes
//            }
//        }, 1000); //Every 300000 ms (5 minutes)

        return mView;
    }

    private void setChatMessages(List<Message> listItems, ChatAdapter adapter) {
        String prevMail = getSavedMail();
        String[] messages = prevMail.split("\n");

        for (String message : messages) {

            if (message.equals("")) {
                continue;
            }

            try {
                JSONObject jsonObject = new JSONObject(message);
                listItems.add(new Message("Вы", jsonObject.getString("date"),
                        jsonObject.getString("time"), jsonObject.getString("text")));
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String getSavedMail() {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        return sharedPref.getString(SAVED_MAIL, "");
    }

    private void setSavedMail(String message) {
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);

        // retrieve prev messages
        String prevMail = getSavedMail();

        // save with new message
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SAVED_MAIL, prevMail + "\n" + message);
        editor.apply();
    }
}
