package ru.atc_consulting.clientapp.recievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

import ru.atc_consulting.clientapp.domain.Message;
import ru.atc_consulting.clientapp.fragments.ChatFragment;

import static android.content.Intent.EXTRA_EMAIL;
import static android.content.Intent.EXTRA_SUBJECT;
import static android.content.Intent.EXTRA_TEXT;

public class GmailReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Email Received", Toast.LENGTH_LONG).show();

        String dataEmail = intent.getDataString();

        String email = intent.getStringExtra(EXTRA_EMAIL);
        String subject = intent.getStringExtra(EXTRA_SUBJECT);
        String extraText = intent.getStringExtra(EXTRA_TEXT);

        Log.d("on.Receive", email + "_ " + extraText);

        if (Objects.equals(email, ChatFragment.MAIL)) {
            ChatFragment.outMessages.add(new Message(email, "15", "15", extraText));
        }

    }
}
